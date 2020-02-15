import React, { Component } from 'react'
import Axios from 'axios'
import Calculation from './Calculation'

export default class Solution extends Component {

    state = {
        submitted: false,
        calculations: [],
        solution: {},
        buttonText: "Add Solution",
        calculationField: false,
        calculationButton: "Show your work"
    }

    componentDidMount = () => {
        let user = JSON.parse(localStorage.getItem("loggedInUser"))
        Axios.get(`/solutions/question/${this.props.question.id}`)
        .then((res) => {
            for(let i=0; i<res.data.length; i++) {
                if(res.data[i].userId === user.id) {
                    this.setState({solution: res.data[i], buttonText: "Update Solution"})
                    Axios.get(`/calculations/solution/${res.data[i].id}`)
                    .then((res) => {
                        this.setState({calculations: res.data, calculationButton: "Add a Calculation"})
                    })
                }
            }
        })
    }

    addSolution = (evt) => {
        evt.preventDefault()
        console.log('event prevent')
        if(this.state.solution.content === undefined) {
            console.log('posting')
            let solution = {
                questionId: this.props.question.id,
                assignmentId: this.props.question.assignmentId,
                userId: JSON.parse(localStorage.getItem("loggedInUser")).id,
                content: evt.target.expression.value
            } 
            this.setState({solution})
            Axios.post('/solutions', solution)
            this.setState({submitted: true})
        } else {
            console.log(this.state.solution)
            let solution = {
                correct: false,
                questionId: this.props.question.id,
                assignmentId: this.props.question.assignmentId,
                userId: JSON.parse(localStorage.getItem("loggedInUser")).id,
                id: this.state.solution.id,
                content: evt.target.expression.value
            }   
            Axios.put('/solutions', solution)
            this.setState({submitted: true})
        }
    }

    calculationField = () => {
        if(this.state.solution.questionId !== undefined){
            Axios.get(`/solutions/question/${this.state.solution.questionId}`)
            .then((res) => {
                console.log(res)
            })
        }
        let toggle = !this.state.calculationField
        this.setState({calculationField: toggle})
    }

    addCalculation = (evt) => {
        evt.preventDefault()
        let calculation = {
            solutionId: this.state.solution.id,
            expression: evt.target.calcExpression.value,
            comment: evt.target.comment.value
        }
        Axios.post('/calculations', calculation)        
    }

    render() {
        let calcMap = this.state.calculations.map((calculation, index) => {
            return <Calculation  key = {index} id = {calculation.id} expression = {calculation.expression} comment = {calculation.comment}/>
        })
        return (
            <div>
                {this.state.submitted? <p>Solution submitted</p> : null}
                <form onSubmit={this.addSolution}>
                    <input type='text' name='expression' defaultValue={this.state.solution.content}></input>
                    <input type='submit' value={this.state.buttonText}/>
                </form>
                     {calcMap}    
                {this.state.calculationField? <form onSubmit={this.addCalculation}>
                    <input type='text' name='calcExpression'></input>
                    <input type='text' name='comment'></input>
                    <input type='submit' value="Add Calculation"></input>
                </form> : null}
                {this.state.solution? <button id='calcFieldButton' onClick={this.calculationField}>{this.state.calculationField? "Cancel":"Add a Calculation"}</button> : null}
            </div>
        )
    }
}
