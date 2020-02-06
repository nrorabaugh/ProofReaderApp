import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import AssignmentView from './components/AssignmentView'
import ClassView from './components/ClassView'
import Login from './components/Login'
function App() {

  return (
    <div className="App">
    <Router>
    <div>
      <Switch>
        <Route exact path="/">
          <Login/>
        </Route>
        <Route path="/class/:id">
          <ClassView/>
        </Route>
        <Route path="/assignment/:id" component={AssignmentView}/>
      </Switch>
    </div>
    </Router>
    </div>
  );
}

export default App;
