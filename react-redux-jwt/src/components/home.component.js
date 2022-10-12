import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";
import { BiAbacus } from "react-icons/bi";
import { BiBookReader } from "react-icons/bi";
import { BiPurchaseTag } from "react-icons/bi";
import { BiSupport } from "react-icons/bi";
import { BiLogOutCircle } from "react-icons/bi";


import { BiStar } from "react-icons/bi";

import { FaLinkedin } from "react-icons/fa";
import { FaInstagram } from "react-icons/fa";

import { AiFillStar } from "react-icons/ai";

class Home extends Component {


  render() {

    return (
      <div class="home">

        <header class="header" >
          <nav>
            <img src="logo.png" class="logo" />
            <ul>
              <li><a href="">HOME</a></li>
              <li><a href="">BULK ORDERS</a></li>
              <li><a href="">PROFILE</a></li>
              <li><a href="about.html">ABOUT US</a></li>
              <li><a href="contact.html">CONTACT US</a></li>
              <li><a href="landing"><BiLogOutCircle/></a></li> 
            </ul>
          </nav>

          <div class="intro">
            <h1>WELCOME TO COUPON COUNTRY</h1>
            <h2>BUY COUPONS BEFORE<br /><span class="dis">THIS 31st SEP</span><br />AT 10%<br />EXTRA DISCOUNT</h2>
            <h3>Only available at CouponCountry</h3>
            <a href="#" class="btn1">BUY NOW</a>
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



        {/* Buy By Category  */}

        <section class="section">
          <div class="h">
            <h1><span>Buy By</span> Categories</h1>
          </div>
          <div class="ab box">
            <div class="item item-1">
              <img src="allenSolly.png" alt="" />
            </div>
            <div class="item item-2">
              <img src="pant.jpg" alt="" />
            </div>
            <div class="item item-3">
              <img src="tv.jpg" alt="" />
            </div>
            <div class="item item-4">
              <img src="food.png" alt="" />
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

        {/* <!-----footer--------------------> */}


        <section id="footer">

          <div class="foot">
            <ul>
              <li><a href="">HOME</a></li>
              <li><a href="about.html">ABOUT US</a></li>
              <li><a href="contact.html">CONTACT US</a></li>
            </ul>

            <div class="social-links">
              <a href=""><i class="fab fa-instagram"><FaInstagram/></i></a>
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

export default connect(mapStateToProps)(Home);

