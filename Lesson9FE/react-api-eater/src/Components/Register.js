var React = require('react')

 AccountFields = React.createClass({
  render: function() {
    return ( <div>
      <label>First Name</label> 
      <input type="text"
             ref="firstName"
             defaultValue={ this.props.fieldValues.firstName } />

     <label>Last Name</label>
     <input type="text"
             ref="lastName"
             defaultValue={ this.props.fieldValues.lastName } />
      
     <label>Username</label>
     <input type="text"
             ref="text"
             defaultValue={ this.props.fieldValues.username } />

      <label>Password</label>
      <input type="password"
             ref="password"
             defaultValue={ this.props.fieldValues.password } />


      <button onClick={ this.saveAndContinue }>Save and Continue</button></div>
    )
  },

  saveAndContinue: function(e) {
    e.preventDefault()

    // Get values via this.refs
    var data = {
      firstName: this.refs.name.getDOMNode().value,
      lastName : this.refs.lastName.getDOMNode().value,
      username : this.refs.username.getDOMNode().value,
      password : this.refs.password.getDOMNode().value,
    }

    this.props.saveValues(data)
    this.props.nextStep()
  }
})

module.exports = AccountFields