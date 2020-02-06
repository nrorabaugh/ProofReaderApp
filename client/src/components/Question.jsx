import React, { Component } from 'react'

export default class Question extends Component {
    render() {
        return (
            <div>
                <p>{this.props.number}</p>
                <p>{this.props.content}</p>
                <p>{this.props.solution}</p>
            </div>
        )
    }
}
