import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";
import { Link } from "react-router-dom";
import './login.css'

import { connect } from "react-redux";
import { register } from "../actions/auth";

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const firstName = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The firstname must be between 3 and 20 characters.
      </div>
    );
  }
};

const lastName = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The lastname must be between 3 and 20 characters.
      </div>
    );
  }
};

const email = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const password = (value) => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

const address = (value) => {
  if (value.length < 3 || value.length > 35) {
    return (
      <div className="alert alert-danger" role="alert">
        The address must be between 3 and 35 characters.
      </div>
    );
  }
};

const contactNumber = (value) => {
  if (value.length != 10) {
    return (
      <div className="alert alert-danger" role="alert">
        The phone Numbder must of 10 digits.
      </div>
    );
  }
};

class Register extends Component {
  constructor(props) {
    super(props);
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangefirstName = this.onChangefirstName.bind(this);
    this.onChangelastName = this.onChangelastName.bind(this);
    this.onChangeemail = this.onChangeemail.bind(this);
    this.onChangepassword = this.onChangepassword.bind(this);
    this.onChangeaddress = this.onChangeaddress.bind(this);
    this.onChangecontactNumber = this.onChangecontactNumber.bind(this);

    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      address: "",
      contactNumber: "",
      successful: false,
    };
  }

  onChangefirstName(e) {
    this.setState({
      firstName: e.target.value,
    });
  }
  onChangelastName(e) {
    this.setState({
      lastName: e.target.value,
    });
  }
  onChangeemail(e) {
    this.setState({
      email: e.target.value,
    });
  }
  onChangepassword(e) {
    this.setState({
      password: e.target.value,
    });
  }

  onChangeaddress(e) {
    this.setState({
      address: e.target.value,
    });
  }
  onChangecontactNumber(e) {
    this.setState({
      contactNumber: e.target.value,
    });
  }

  handleRegister(e) {
    e.preventDefault();

    this.setState({
      successful: false,
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      this.props
        .dispatch(
          register(
            this.state.firstName,
            this.state.lastName,
            this.state.email,
            this.state.password,
            this.state.address,
            this.state.contactNumber,
          )
        )
        .then(() => {
            this.setState({
            successful: true,
            
          });
         this.props.history.push("/login");
          alert("Registered successfully, Login to continue");
          console.log("Registered successfully");
        })
        .catch(() => {
          this.setState({
            successful: false,
          });
        });
    }
  }

  render() {
    const { message } = this.props;

    return (
      <div>      

        <Form
          onSubmit={this.handleRegister}
          ref={(c) => {
            this.form = c;
          }}
        >
         
        <div className="container-fluid ps-md-0" style={{ marginTop: "0px" }}>         
            
            
            
      
        

        <div className="col-md-4 bg-image" style={{ margin: "50px" }}>
          <div className="col-md-12 card bg-light text-dark" style={{ marginLeft: "700px" }} >
            <h1>
              <center>User Registration </center>
            </h1>

              {!this.state.successful && (
                <div>
                  <div className="form-group">
                    <Input
                      type="text"
                      className="form-control"
                      firstName="firstName"
                      value={this.state.firstName}
                      onChange={this.onChangefirstName}
                      validations={[required, firstName]}
                      placeholder="Enter your firstName"
                    />
                  </div>

                  <div className="form-group">
                    <Input
                      type="text"
                      className="form-control"
                      lastName="lastName"
                      value={this.state.lastName}
                      onChange={this.onChangelastName}
                      validations={[required, lastName]}
                      placeholder="Enter your lastName"
                    />
                  </div>

                  <div className="form-group">
                    <Input
                      type="text"
                      className="form-control"
                      name="email"
                      value={this.state.email}
                      onChange={this.onChangeemail}
                      validations={[required, email]}
                      placeholder="Enter your Email"
                    />
                  </div>

                  <div className="form-group">
                    <Input
                      type="password"
                      className="form-control"
                      name="password"
                      value={this.state.password}
                      onChange={this.onChangepassword}
                      validations={[required, password]}
                      placeholder="Enter your password"
                    />
                  </div>

                  <div className="form-group">
                    <Input
                      type="text"
                      className="form-control"
                      name="address"
                      value={this.state.address}
                      onChange={this.onChangeaddress}
                      validations={[required, address]}
                      placeholder="Enter your address"
                    />
                  </div>

                  <div className="form-group">
                    <Input
                      type="tel"
                      className="form-control"
                      name="contactNumber"
                      value={this.state.contactNumber}
                      onChange={this.onChangecontactNumber}
                      validations={[required, contactNumber]}
                      placeholder="Enter your contactNumber"
                    />
                  </div>

                  <div className="form-group">
                    <button className="btn btn-dark btn-block">Sign Up</button>
                    <h2></h2>
                    <p>
                      <i>
                        <h6>
                          Already Have an Account ?{" "}
                          <Link to="/login" className="formFieldLink">
                            Sign In
                          </Link>
                        </h6>
                      </i>
                    </p>
                  </div>
                  {/* <p className="mt-3">Already Have an Account <a href="login.components.js">Sign In</a></p> */}
                </div>
              )}

              {message && (
                <div className="form-group">
                  <div
                    className={
                      this.state.successful
                        ? "alert alert-success"
                        : "alert alert-danger"
                    }
                    role="alert"
                  >
                    {message}
                  </div>
                </div>
              )}
              <CheckButton
                style={{ display: "none" }}
                ref={(c) => {
                  this.checkBtn = c;
                }}
              />
            
          </div>
        </div>
      </div>
      </Form>
      </div>

    );
  }
}

function mapStateToProps(state) {
  const { message } = state.message;
  return {
    message,
  };
}

export default connect(mapStateToProps)(Register);
