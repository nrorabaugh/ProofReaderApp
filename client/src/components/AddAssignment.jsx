import React, { Component } from 'react'
import Axios from 'axios'
import QuestionThumbnail from './QuestionThumbnail'

export default class addAssignment extends Component {
    state = {
        classId: null,
        assignment: {},
        questionForm: false,
        questions: [],
        newQuestion: false,
        remapIndex: 0
    }

    componentDidMount() {
        const { match: { params } } = this.props
        this.setState({classId: params.classId})
    }

    componentDidUpdate = async () => {
        if(this.state.assignment !== undefined && this.state.assignment.id === undefined) {
            Axios.get(`/assignments/name/${this.state.assignment.name}`)
            .then(async (res) => {
                await this.setState({assignment: res.data[0]})
            })
        }
    }
 
    addAssignment = (evt) => {
        evt.preventDefault()
        let assignment = {
            classId: this.state.classId,
            name: evt.target.name.value,
            description: evt.target.description.value
        }
        Axios.post('/assignments', assignment)
        this.setState({assignment})
        Axios.get(`/assignments/name/${assignment.name}`)
        .then(async (res) => {
            await this.setState({assignment: res.data[0]})
        })
    }

    addQuestion = () => {
        this.setState({questionForm: true})
    }

    render() {
        let remapIndex = this.state.remapIndex
        let questMap = this.state.questions.map((question, index) => {
            return <QuestionThumbnail  key = {index + (remapIndex * this.state.questions.length)} id = {question.id} number = {question.number} content = {question.content} solution = {question.solution}/>
        })
        return (
            <div>
                <form onSubmit={this.addAssignment}>
                    <input type='text' name='name'></input>
                    <input type='text' name='description'></input>
                    <input type='submit' value='Add Assignment'></input>
                </form>
                {questMap}
                {this.state.questionForm?
                    <form onSubmit={this.submitQuestion}>
                        <input type='text' name='number' placeholder='Number'></input>
                        <input type='text' name='content' placeholder='Prompt'></input>
                        <input type='text' name='solution' placeholder='Answer'></input>
                        <input type='submit' value='Add Question'></input>
                    </form> : null}
                <button onClick={this.addQuestion}>Add a Question</button>
                <button onClick={this.click}>Console</button>
            </div>
        )
    }
}
