import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import PostList from './PostList';



class App extends Component {
  render() {
    return (
     
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/posts' exact={true} component={PostList}/>
           
          </Switch>
        </Router>
     
    )
  }
}

export default App;