import React, { Component } from 'react'
import Axios from 'axios'
import Question from './Question'
import Message from './Message'

export default class AssignmentView extends Component {
    state = {
        assignment: null,
        questions: [],
        messages: []
    }

    componentDidMount() {
        const { match: { params } } = this.props
        Axios.get(`/assignments/${params.id}`)
        .then((res) => {
            this.setState({assignment: res.data}) 
        })
        Axios.get(`/questions/assignment/${params.id}`)
        .then((response) => {
            this.setState({questions: response.data})
        })
        Axios.get(`/messages/assignment/${params.id}`)
        .then((res) => {
            this.setState({messages: res.data})
        })
    }

    render() {
        let questionsMap = this.state.questions.map((question, index) => {
            return <Question  key = {index} number = {question.number} content = {question.content} solution = {question.solution}/>
        })
        let messagesMap = this.state.messages.map((message, index) =>{
            return <Message key={index} senderId={message.senderId} content={message.content}/>
        })
        return (
            <div>
                <div className='header'>
                    <p>{this.state.assignment? this.state.assignment.name : null}</p>
                </div>
                <div className='assignmentContent'>
                    <div className = 'switch'>
                        {questionsMap}
                    </div>
                    <div className = 'chat'>
                        {messagesMap}
                    </div>
                </div>
            </div>
        )
    }
}
