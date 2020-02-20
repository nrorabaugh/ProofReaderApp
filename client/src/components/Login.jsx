import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import Axios from 'axios'

export default class Login extends Component {
    state = {
        users: [],
        currentUserHandle: '',
        currentPasswordHandle: '',
        loggedInUser: null
    }

    login = (evt) => {
        evt.preventDefault()
        Axios.get(`/users/username:${this.state.currentUserHandle}/password:${this.state.currentPasswordHandle}`)
        .then((res) => {
            localStorage.setItem("loggedInUser", JSON.stringify(res.data[0]))
            this.setState({loggedInUser: res.data[0]})
        })
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
        if(this.state.loggedInUser && this.state.loggedInUser.role==="teacher") {href = `/admin/class/${this.state.loggedInUser.id}`}
        if(this.state.loggedInUser && this.state.loggedInUser.role==="student") {href = `/class/${this.state.loggedInUser.classId}`}
        return (
            <div>
                { this.state.loggedInUser? <Redirect to={href}/> :
                <div><form onSubmit={this.login}>
                    <input type='text' name='username' autoComplete='off' placeholder='Username' onChange={this.userHandle}/>
                    <input type='password' name='password' autoComplete='off' placeholder='Password' onChange={this.passwordHandle}/>
                    <input className='submit' type='submit' value='Enter'/>
                </form>  
                <a href='/signup'>New User?</a>
                </div>}
            </div>
        )
    }
}
