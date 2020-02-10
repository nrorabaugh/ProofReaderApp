import React, { Component } from 'react'
import Axios from 'axios'
import Question from './Question'
import Message from './Message'
 
export default class AssignmentView extends Component {
   state = {
       assignment: null,
       questions: [],
       currentQuestion: {},
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
           this.setState({questions: response.data, currentQuestion: response.data[0]})
       })
       Axios.get(`/messages/assignment/${params.id}`)
       .then((res) => {
           console.log(res.data)
           this.setState({messages: res.data})
       })
   }
 
   nextQuestion = () => {
       let currentQuestionIndex = this.state.questions.indexOf(this.state.currentQuestion)
       this.setState({currentQuestion: this.state.questions[(currentQuestionIndex+1)]})
   }
 
   sendMessage = (evt) => {
       evt.preventDefault()
       let userId = (JSON.parse(localStorage.getItem("loggedInUser"))).id
       let assignmentId = this.state.assignment.id
       let message = {
           senderId: userId,
           content: evt.target.messageValue.value,
           assignmentId: assignmentId,
           eq: null
       }
       console.log(message)
       Axios.post('/messages', message)
   }
 
   render() {
       // let questionsMap = this.state.questions.map((question, index) => {
       //     return <Question  key = {index} number = {question.number} content = {question.content} solution = {question.solution}/>
       // })
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
                       <Question
                       number={this.state.currentQuestion.number}
                       content={this.state.currentQuestion.content}
                       solution={this.state.currentQuestion.solution}
                       />
                       <button onClick={this.nextQuestion}>Next Question</button>
                   </div>
                   <div className = 'chat'>
                       {messagesMap}
                       <form onSubmit={this.sendMessage}>
                           <input type='text' name='messageValue' autoComplete='off' placeholder='Send a message...'/>
                           <input type='submit' value='Send'/>
                       </form>
                   </div>
               </div>
           </div>
       )
   }
}

