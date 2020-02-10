import React, { Component } from 'react'
 
export default class Question extends Component {
   render() {
       return (
           <div className='question'>
               <h1>{this.props.number}</h1>
               <p>{this.props.content}</p>
               <p>{this.props.solution}</p>
           </div>
       )
   }
}
