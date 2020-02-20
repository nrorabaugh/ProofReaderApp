import React, { Component } from 'react'
import Axios from 'axios'
import AssignmentThumbnail from './AssignmentThumbnail'

export default class TeacherClassView extends Component {
    state = {
        classData: null,
        assignments: [],
        user: null,
    }

    componentDidMount() {
        let user = JSON.parse(localStorage.getItem("loggedInUser"))
        this.setState({user})
        Axios.get(`/classrooms/teacher/${user.id}`)
        .then((res) => {
            this.setState({classData: res.data[0]})
        })
        Axios.get(`/assignments/class/${user.classId}`)
        .then((res) => {
            this.setState({assignments: res.data})
        })
        // localStorage.clear()
    }

    render() {
        let assignmentsMap = this.state.assignments.map((assignment, index) => {
            return <AssignmentThumbnail  key = {index} id = {assignment.id} classId = {assignment.classId} name = {assignment.name} description = {assignment.description}/>
        })
        let href = null
        if(this.state.classData) {
            href = `/admin/addAssignment/${this.state.classData.id}`
        }
        return (
            <div>
                <div className='header'>
                    <p>{this.state.classData? this.state.classData.name : 'Class'}</p>
                    <a href={href}>Add Assignment</a>
                </div>
                <div className='pageWrapper'>
                    <div className='assignmentList'>
                        {assignmentsMap}
                    </div>
                    <div className='scorecard'>

                    </div>
                    <button onClick={() => { console.log(this.state)}}>State</button>
                </div>
            </div>
        )
    }
}
