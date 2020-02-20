import React, { Component } from 'react'
import AssignmentThumbnail from './AssignmentThumbnail'
import Axios from 'axios'

export default class Classview extends Component {
    state = {
        classData: null,
        assignments: [],
        assignmentToRedirect: null,
        user: null,
        listening: [],
        percentage: 0
    }

    componentDidMount() {
        let user = JSON.parse(localStorage.getItem("loggedInUser"))
        this.setState({user})
        Axios.get(`/classrooms/${user.classId}`)
        .then((res) => {
            this.setState({classData: res.data[0]})
            localStorage.setItem("currentClass", res.data)
        })
        Axios.get(`/assignments/class/${user.classId}`)
        .then((res) => {
            this.setState({assignments: res.data})
        })
        // localStorage.clear()
        Axios.get(`/solutions/student/${user.id}`)
        .then((res) => {
            console.log(res)
            let correct = 0
            for(let i=0; i<res.data.length; i++) {
                console.log(correct)
                if(res.data[i].correct === true) {
                    correct +=1
                    console.log('+1')
                }
            }
            let frac = (correct/res.data.length) * 100
            document.getElementsByClassName('correctbar')[0].style.width = `${frac}%`
        })
    }



    render() {
        let assignmentsMap = this.state.assignments.map((assignment, index) => {
            return <AssignmentThumbnail  key = {index} id = {assignment.id} name = {assignment.name}/>
        })
        return (
            <div>
                <div className='header'>
                    <p>{this.state.classData? this.state.classData.name : 'Class'}</p>
                </div>
                <div className='pageWrapper'>
                    <div className='assignmentList'>
                        {assignmentsMap}
                    </div>
                    <div className='scorecard'>
                        <div className='scorebar'>
                            <div className='correctbar'></div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}