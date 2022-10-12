import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";

import { BiLogOutCircle } from "react-icons/bi";



class Admin extends Component {
    render() {

        return (
            <div className="col-md-12">
                <div className="card bg-light text-dark">
                    <div class="admin">

                        <h2>Welcome Admin!!</h2>

                        <header class="header" >

                            <nav>
                                <img src="logo.png" class="logo" />
                                <ul>
                                    <li><a href="landing">LOG OUT<BiLogOutCircle /></a></li>

                                </ul>
                            </nav>

                            <ul >
                                <li><a href="addproduct">Add Coupon</a></li>
                                <li><a href="updateproduct">Update Coupon</a></li>
                                {/* <li><a href="">Delete Coupon</a></li> */}
                                <li><a href="listproducts">Get All Coupon </a></li>

                                
                            </ul>

                        </header>

                    </div>
                </div>
            </div >
        );
    }
}

function mapStateToProps(state) {
    const { user } = state.auth;
    return {
        user,
    };
}

export default connect(mapStateToProps)(Admin);