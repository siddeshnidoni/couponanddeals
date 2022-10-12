import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import { connect } from "react-redux";
import { addCoupon } from "../actions/auth";
import CheckButton from "react-validation/build/button";
import { BiLogOutCircle } from "react-icons/bi";

const required = (value) => {
    if (!value) {
      return (
        <div className="alert alert-danger" role="alert">
          This field is required!
        </div>
      );
    }
  };
const couponName = (value) => {
    if (value.length < 3 || value.length > 20) {
        return (
            <div className="alert alert-danger" role="alert">
                The Coupon name must be between 3 and 20 characters.
            </div>
        );
    }
};

const couponValidity = (value) => {
    if (value.length < 3 || value.length > 30) {
        return (
            <div className="alert alert-danger" role="alert">
                The Expiry Coupon Date must be Valid
            </div>
        );
    }
};

const description = (value) => {
    if (value.length < 3 || value.length > 40) {
        return (
            <div className="alert alert-danger" role="alert">
                The Coupon description must be between 3 and 40 characters.
            </div>
        );
    }
};

const couponCode = (value) => {
    if (value.length < 3 || value.length > 10) {
        return (
            <div className="alert alert-danger" role="alert">
                The Coupon Code must be between 3 and 10 characters.
            </div>
        );
    }
};

const couponCategory = (value) => {
    if (value.length < 3 || value.length > 10) {
        return (
            <div className="alert alert-danger" role="alert">
                The Coupon Category must be between 3 and 10 characters.
            </div>
        );
    }
};


const couponPrice = (value) => {
    if (value.length === 0) {
        return (
            <div className="alert alert-danger" role="alert">
                enter valid price!!
            </div>
        );
    }
};


const couponQuantity = (value) => {
    if (value.length === 0) {
        return (
            <div className="alert alert-danger" role="alert">
                enter valid quantity!
            </div>
          ) ;
    }
};

const couponBrand = (value) => {
    if (value.length < 3 || value.length > 10) {
        return (
            <div className="alert alert-danger" role="alert">
                The Coupon Brand must be between 3 and 10 characters.
            </div>
        );
    }
};



    class UpdateProd extends Component {
        constructor(props) {
            super(props);
            this.handleAddProd = this.handleAddProd.bind(this);
            this.onChangecouponName = this.onChangecouponName.bind(this);
            this.onChangecouponValidity = this.onChangecouponValidity.bind(this);
            this.onChangedescription = this.onChangedescription.bind(this);
            this.onChangecouponCode = this.onChangecouponCode.bind(this);
            this.onChangecouponCategory = this.onChangecouponCategory.bind(this);
            this.onChangecouponPrice = this.onChangecouponCategory.bind(this);
            this.onChangecouponQuantity = this.onChangecouponQuantity.bind(this);
            this.onChangecouponBrand = this.onChangecouponBrand.bind(this);
            

            this.state = {
                couponName: "",
                couponValidity: "",
                description: "",
                couponCode: "",
                couponCategory: "",
                couponPrice: "",
                couponQuantity: "",
                couponBrand: "",
            };
        }

        onChangecouponName(e) {
            this.setState({
                couponName: e.target.value,
            });
        }

        onChangecouponValidity(e) {
            this.setState({
                couponValidity: e.target.value,
            });
        }

        onChangedescription(e) {
            this.setState({
                description: e.target.value,
            });
        }

        onChangecouponCode(e) {
            this.setState({
                couponCode: e.target.value,
            });
        }

        onChangecouponCategory(e) {
            this.setState({
                couponCategory: e.target.value,
            });
        }

        onChangecouponPrice(e) {
            this.setState({
                couponPrice: e.target.value,
            });
        }

        onChangecouponQuantity(e) {
            this.setState({
                couponQuantity: e.target.value,
            });
        }

        onChangecouponBrand(e) {
            this.setState({
                couponBrand: e.target.value,
            });
        }


        handleUpdateProd(e) {
            e.preventDefault();

            this.setState({
                successful: false,
            });

            this.form.validateAll();

            if (this.checkBtn.context._errors.length === 0) {
                this.props
                    .dispatch(
                        addCoupon(this.state.couponName, this.state.couponValidity, this.state.description, this.state.couponCode, this.state.couponCategory, this.state.couponPrice, this.state.couponQuantity, this.state.couponBrand)
                        
                        )
                    
                    .then(() => {
                        this.setState({
                            successful: true,
                           
                        });
                        alert("coupon Updated successfully");
                        this.props.history.push('/admin');
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

                <div className="col-md-12">
                    <div className="card bg-light text-dark">
                    <nav>
            <img src="logo.png" class="logo" />
            <ul>
              <li><a href="admin">Go Back<BiLogOutCircle/></a></li>
              
            </ul>
          </nav>

                        <h1><center>Update Product </center></h1>

                        <Form
                            onSubmit={this.handleAddProd}
                            ref={(c) => {
                                this.form = c;
                            }}
                        >
                            {!this.state.successful && (
                                <div>
                                   <div className="form-group">
                                        <label htmlFor="couponName">Coupon Name</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponName"
                                            value={this.state.couponName}
                                            onChange={this.onChangecouponName}
                                            validations={[required, couponName]}
                                        />
                                    </div>

                                    <div className="form-group">
                                        <i class="fas fa-envelope prefix grey-text d-flex"></i>
                                        <label htmlFor="couponValidity">Coupon Validity</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponValidity"
                                            value={this.state.couponValidity}
                                            onChange={this.onChangecouponValidity}
                                            validations={[required, couponValidity]}
                                        />
                                    </div>

                                    <div className="form-group">
                                        <i class="fas fa-envelope prefix grey-text d-flex"></i>
                                        <label htmlFor="productPrice">Description</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="description"
                                            value={this.state.description}
                                            onChange={this.onChangedescription}
                                            validations={[required, description]}
                                        />
                                    </div>

                                    <div className="form-group">
                                        <i class="fas fa-envelope prefix grey-text d-flex"></i>
                                        <label htmlFor="productPrice">Coupon Code</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponCode"
                                            value={this.state.couponCode}
                                            onChange={this.onChangecouponCode}
                                            validations={[required, couponCode]}
                                        />
                                    </div>

                                    <div className="form-group">
                                        <i class="fas fa-envelope prefix grey-text d-flex"></i>
                                        <label htmlFor="productPrice">Coupon Category</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponCategory"
                                            value={this.state.couponCategory}
                                            onChange={this.onChangecouponCategory}
                                            validations={[required, couponCategory]}
                                        />
                                    </div>

                                    <div className="form-group">
                                        <i class="fas fa-envelope prefix grey-text d-flex"></i>
                                        <label htmlFor="productPrice">Coupon Price</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponPrice"
                                            value={this.state.couponPrice}
                                            onChange={this.onChangecouponPrice}
                                            validations={[required, couponPrice]}
                                        />
                                    </div>

                                    <div className="form-group">
                                        <i class="fas fa-envelope prefix grey-text d-flex"></i>
                                        <label htmlFor="productPrice">Coupon Quantity</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponQuantity"
                                            value={this.state.couponQuantity}
                                            onChange={this.onChangecouponQuantity}
                                            validations={[required, couponQuantity]}
                                        />
                                    </div>


                                    <div className="form-group">
                                        <label htmlFor="productQuantity">Coupon Brand</label>
                                        <Input
                                            type="text"
                                            className="form-control"
                                            name="couponBrand"
                                            value={this.state.couponBrand}
                                            onChange={this.onChangecouponBrand}
                                            validations={[required, couponBrand]}
                                        />
                                    </div>
                                </div>
                            )}

                            {message && (
                                <div className="form-group">
                                    <div className={this.state.successful ? "alert alert-success" : "alert alert-danger"} role="alert">
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
                        </Form>


                    </div>
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

    export default connect(mapStateToProps)(UpdateProd);