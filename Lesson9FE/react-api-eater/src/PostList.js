import React, { Component } from 'react';
import { Button, Buttonpost, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class PostList extends Component {

  constructor(props) {
    super(props);
    this.state = {posts: [], isLoading: true};
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('api/post')
      .then(response => response.json())
      .then(data => this.setState({posts: data, isLoading: false}));
  }

  async remove(id) {
    await fetch(`/api/post/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedposts = [...this.state.posts].filter(i => i.id !== id);
      this.setState({posts: updatedposts});
    });
  }

  render() {
    const {posts, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const postList = posts.map(post => {
      const message = `${post.message || ''} ${post.authorID || ''} ${post.timeStamp || ''}`;
      return <tr key={post.id}>
        <td style={{whiteSpace: 'nowrap'}}>{post.id}</td>
        <td>{message}</td>
        <td>{post.events.map(event => {
          return <div key={event.id}>{new Intl.DateTimeFormat('en-US', {
            year: 'numeric',
            month: 'long',
            day: '2-digit'
          }).format(new Date(event.date))}: {event.title}</div>
        })}</td>
        <td>
          <Buttonpost>
            <Button size="sm" color="primary" tag={Link} to={"/posts/" + post.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(post.id)}>Delete</Button>
          </Buttonpost>
        </td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/posts/new">Add post</Button>
          </div>
          <h3>My Posts</h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th width="20%">ID</th>
              <th width="20%">authorID</th>
              <th>message</th>
              
            </tr>
            </thead>
            <tbody>
            {postList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default PostList;