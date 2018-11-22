var axios = require('axios');

module.exports = {
    fetchPosts: function() {
        var encodedURI = window.encodeURI('http://localhost:8080/api/posts');
        return axios.get(encodedURI).then(response => {
            console.log('fetchPosts: ', response.data);
            return response.data;
        });
    }
};