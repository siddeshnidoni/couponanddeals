import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";
import { AiFillStar } from "react-icons/ai";
import { BiBookReader } from "react-icons/bi";
import { BiPurchaseTag } from "react-icons/bi";
import { BiSupport } from "react-icons/bi";
class Landing extends Component {


    render() {

        return (

        <div class="home">

        <header class="header" >
          <nav>
            <img src="logo.png" class="logo" />
            <ul>
              <li><a href="about.html">ABOUT US</a></li>
              <li><a href="contact.html">CONTACT US</a></li>
            </ul>
          </nav>

          <div class="landing">
            <h2>Welcome To</h2><br/> <h1>CouponCountry</h1> <br/> <h2>Store!!</h2>
          </div>

        </header>

        <section class="section benefits">
          <div class="benefit-center box" >
            <div class="benefit">
              <span class="icon"><i class="bx bx-book-reader"><BiBookReader/></i></span>
              <h4>10-Day Returns</h4>
              <span class="text">Buy Coupon without any fear</span>
            </div>
            <div class="benefit">
              <span class="icon"><i class="bx bx-headphone"><BiSupport/></i></span>
              <h4>24/7 Support</h4>
              <span class="text">We are always there to help you</span>
            </div>
          </div>
        </section>


        {/* Coupons  */}

        <section class="section">
          <div class="h">
            <h1><span>Coupon</span> Country</h1>
          </div>
          <div class="ac-center box">
            <div class="ac">
              <div class="img-cover">
                <img src="flipcartCoupon.png" alt="" />
              </div>
              <p>Upto 8% Off On Electronic Products in Flipkart</p>
              <div class="price">INR 300</div>
            </div>

            <div class="ac">
              <div class="img-cover">
                <img src="allenSolly1.png" alt="" />
              </div>
              <p>Upto 12% Off On Outfits in AllenSolly</p>
              <div class="price">INR 200</div>
            </div>

            <div class="ac">
              <div class="img-cover">
                <img src="myGlamm.png" alt="" />
              </div>
              <p>Upto 9% Off On makeup Products in MyGlamm </p>
              <div class="price">INR 250</div>
            </div>

            <div class="ac">
              <div class="img-cover">
                <img src="firstCry.png" alt="" />
              </div>
              <p>Upto 18% Off On toys in FirstCry</p>
              <div class="price">INR 450</div>
            </div>

            <div class="ac">
              <div class="img-cover">
                <img src="jockey.png" alt="" />
              </div>
              <p>Upto 13% Off On tops in Jockey</p>
              <div class="price">INR 400</div>
            </div>
            <div class="ac">
              <div class="img-cover">
                <img src="cleartrip.jpeg" alt="" />
              </div>
              <p>Upto 18% Off On 8 days package trip in Cleartrip</p>
              <div class="price">INR 1399</div>
            </div>
          </div>
        </section>




        {/* <!-- Best Deals --> */}
        <section class="section">
          <div class="h">
            <h1>Best <span>Deals</span></h1>
          </div>
          <div class="ac-center box">
            <div class="ac">
              <div class="img-cover">
                <img src="amazon.png" alt="" />
              </div>
              <p>Upto 23% Off On grocery Products in Amazon Pay</p>
              <div class="price">INR 430</div>
            </div>

            <div class="ac">
              <div class="img-cover">
                <img src="croma.png" alt="" />
              </div>
              <p>Upto 21% Off On Electronics Products in Croma</p>
              <div class="price">INR 6000</div>
            </div>

            <div class="ac">
              <div class="img-cover">
                <img src="manyavar.png" alt="" />
              </div>
              <p>Upto 19% Off On Outfits in Manyavar</p>
              <div class="price">INR 1200</div>
            </div>
            <div class="ac">
              <div class="img-cover">
                <img src="ajio.png" alt="" />
              </div>
              <p>Upto 20% Off On Outfits in ajio</p>
              <div class="price">INR 900</div>
            </div>
          </div>
        </section>
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

export default connect(mapStateToProps)(Landing);
