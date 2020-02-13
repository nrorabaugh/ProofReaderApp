import React, { Component } from 'react'

export default class Calculation extends Component {
    render() {
        return (
            <div className='calculation'>
                <strong className='calcContent'>{this.props.expression}</strong>
                <p className='calcContent'><em className='calcContent'>{this.props.comment}</em></p>
            </div>
        )
    }
}
