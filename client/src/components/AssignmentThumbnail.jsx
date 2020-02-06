import React, { Component } from 'react'

export default class AssignmentThumbnail extends Component {
    render() {
        let href = `/assignment/${this.props.id}`
        return (
            <a href={href}>
                <div className='assignmentThumb'>
                    <p>{this.props.name}</p>
                </div>
            </a>
        )
    }
}