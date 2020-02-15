import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import axios from 'axios'

export default class Login extends Component {
    state = {
        users: [],
        currentUserHandle: '',
        currentPasswordHandle: '',
        loggedInUser: null
    }

    componentDidMount = () => {
        axios.get('/users')
        .then((res) => {
            this.setState({users: res.data})
        })
    }

    login = (evt) => {
        evt.preventDefault()
        for(let i=0; i<this.state.users.length; i++) {
            if(this.state.currentUserHandle === this.state.users[i].username) {
                if(this.state.currentPasswordHandle === this.state.users[i].password) {
                    this.setState({loggedInUser: this.state.users[i]})
                    localStorage.setItem("loggedInUser", JSON.stringify(this.state.users[i]))
                    return
                } else {
                    return
                }
            }
        }
        console.log('invalid username: ' + this.state.currentUserHandle)
        return
    }
    
    userHandle = (evt) => {
        const currentUserHandle = evt.target.value
        this.setState({currentUserHandle})
    }

    passwordHandle = (evt) => {
        const currentPasswordHandle = evt.target.value
        this.setState({currentPasswordHandle})
    }

    render() {
        let href = null
        if(this.state.loggedInUser && this.state.loggedInUser.role==="teacher") {href = `/admin/class/${this.state.loggedInUser.classId}`}
        if(this.state.loggedInUser && this.state.loggedInUser.role==="student") {href = `/class/${this.state.loggedInUser.classId}`}
        return (
            <div>
                { this.state.loggedInUser? <Redirect to={href}/> :
                <form onSubmit={this.login}>
                    <input type='text' name='username' autoComplete='off' placeholder='Username' onChange={this.userHandle}/>
                    <input type='password' name='password' autoComplete='off' placeholder='Password' onChange={this.passwordHandle}/>
                    <input className='submit' type='submit' value='Enter'/>
                </form>  }
            </div>
        )
    }
}
