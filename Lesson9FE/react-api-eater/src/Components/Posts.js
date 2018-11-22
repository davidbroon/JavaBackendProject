import React from 'react';
import * as api from '../utils/api';

class Posts extends React.Component {
    state = {
        Posts: []
    };

    callPosts = () => {
        api.fetchPosts().then(response => {
            console.log('callPosts: ', response);
            this.setState(() => {
                return {
                    Posts: response
                };
            });
            console.log('after SetState: ', this.state.Posts);
        });
    };

    componentDidMount() {
        this.callPosts();
        console.log('componentDidMount: ', this.state.Posts);
    }

    render() {
        return <div>{this.state.Posts}</div>;
    }
}

export default Posts;