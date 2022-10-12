import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import couponService from "../services/couponService";
import { connect } from "react-redux";
import { BiLogOutCircle } from "react-icons/bi";


class ListProducts extends Component {

    constructor(props) {
        super(props);



        this.state = {
            coupons:[]
        }
        this.deleteCoupon = this.deleteCoupon.bind(this);


    }

    deleteCoupon(couponId){
        couponService.deleteCoupon(couponId).then( res => {
            console.log("couponId");
            this.setState({coupons: this.state.coupons.filter(coupons => coupons.couponId !== couponId)});
            alert("Deleted successfully");
        });
    }


    componentDidMount(){
        couponService.getAllCoupons().then((res)=>{
            this.setState({coupons:res.data});
        })
    }

    render() {
        return (

            <div className="col-md-12">
                    <div className="card bg-light text-dark">
                    <nav>
            <img src="logo.png" class="logo" />
            <ul>
              
              <li><a href="admin">Go Back<BiLogOutCircle/></a></li>
              
            </ul>
          </nav>
          </div>
          
            <div>

                 <br></br>
                 <h2 className="text-center">Coupons List</h2>
                 <br/>
                        <table className = "table table-striped table-bordered text-center ">

                            <thead>
                                <tr>
                                    <th> Coupon Id </th>
                                    <th> Coupon Name</th>
                                    <th> Coupon Validity</th>
                                    <th> Description</th>
                                    <th> Coupon Code</th>
                                    <th> Coupon Category</th>
                                    <th> Coupon Price</th>
                                    <th> Coupon Quantity</th>
                                    <th> Coupon Brand</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.coupons.map(
                                        coupon => 
                                        <tr key = {coupon.couponId}>
                                             <td>{coupon.couponId}</td>
                                             <td> {coupon.couponName} </td>   
                                             <td> {coupon.couponValidity}</td>
                                             <td> {coupon.description}</td>
                                             <td> {coupon.couponCode}</td>
                                             <td> {coupon.couponCategory}</td>
                                             <td> {coupon.couponPrice}</td>
                                             <td> {coupon.couponQuantity}</td>
                                             <td> {coupon.couponBrand}</td>
                                             <td>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCoupon(coupon.couponId)} className="btn btn-danger">Delete </button>

                                             </td>
                                        </tr>
                                        
                                    )
                                }
                            </tbody>
                        </table>

                 </div>
                 </div>            
          
        )
    }
}

function mapStateToProps(state) {
    const { message } = state.message;
    return {
        message,
    };
}
export default connect(mapStateToProps)(ListProducts);