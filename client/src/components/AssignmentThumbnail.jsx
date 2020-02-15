import React, { Component } from 'react'
import Axios from 'axios'
import QuestionThumbnail from './QuestionThumbnail'

export default class AssignmentThumbnail extends Component {
    state = {
        assignment: {
            classId: this.props.classId,
            id: this.props.id,
            name: this.props.name,
            description: this.props.description
        },
        update: false,
        questions: [],
        remapIndex: -1,
        addQuestion: false
    }

    componentDidMount() {
        Axios.get(`/questions/assignment/${this.props.id}`)
        .then((res) => {
            res.data.sort((a, b) => {
                return a.number-b.number
            })
            this.setState({questions: res.data})
        })
    }

    update = () => {
        let update = !this.state.update
        let remapIndex = this.state.remapIndex +1
        this.setState({remapIndex, update})
    }

    updateAssignment = (evt) => {
        evt.preventDefault()
        let assignment = {
            name: evt.target.name.value,
            description: evt.target.description.value,
            id: this.props.id,
            classId: this.props.classId
        }
        Axios.put('/assignments', assignment)
        this.setState({assignment})
        setTimeout(300, () => {})
    }

    addQuestion = () => {
        let toggle = !this.state.addQuestion
        this.setState({addQuestion: toggle})
    } 

    submitQuestion = (evt) => {
        evt.preventDefault()
        let question = {
            number: evt.target.number.value,
            content: evt.target.content.value,
            solution: evt.target.solution.value,
            assignmentId: this.props.id
        }
        Axios.post('/questions', question)
        let questions = this.state.questions
        questions.push(question)
        questions.push(question)
        questions.sort((a, b) => {
            return a.number-b.number
        })
        this.setState({questions})
    }

    render() {
        let role = JSON.parse(localStorage.getItem("loggedInUser")).role
        let href = null
        if(role === "teacher") { href = `/admin/assignment/${this.props.id}` }
        if(role === "student") { href = `/assignment/${this.props.id}` }
        let remapIndex = this.state.remapIndex
        let questMap = this.state.questions.map((question, index) => {
            return <QuestionThumbnail  key = {index + (remapIndex * this.state.questions.length)} id = {question.id} assignmentId = {question.assignmentId} number = {question.number} content = {question.content} solution = {question.solution}/>
        })
        return (
            <div>
                <a href={href}>
                <div className='assignmentThumb'>
                    <p>{this.state.assignment.name}</p>   
                </div>
                </a>
                {role === 'teacher'? <button onClick = {this.update}>{this.state.update?"Cancel" : "Update Assignment"}</button>:null}
                {this.state.update? <div><form onSubmit={this.updateAssignment}>
                        <input type='text' name='name' defaultValue={this.props.name}></input>
                        <input type='text' name='description' defaultValue={this.props.description}></input>
                        <input type='submit' value='Update Assignment'></input>
                    </form>
                        <div>
                            {questMap}
                        </div>
                        <button onClick={this.addQuestion}>{this.state.addQuestion? "Cancel":"Add A Question"}</button>
                        {this.state.addQuestion? <form onSubmit={this.submitQuestion}>
                        <input type='text' name='number' placeholder='Number'></input>
                        <input type='text' name='content' placeholder='Prompt'></input>
                        <input type='text' name='solution' placeholder='Answer'></input>
                        <input type='submit' value='Add Question'></input>
                        </form> : null}
                    </div>: null}
            </div>
        )
    }
}