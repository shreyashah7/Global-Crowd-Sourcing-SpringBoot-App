import React, { Component } from 'react';
import './mainheader.css';
import * as UserHelper from '../_helper/helper';
import { Link } from 'react-router-dom';
import * as API from '../../api/API';

class MainHeader extends Component {

    state = {
        isLoggedIn: false,
        message: '',
        user: UserHelper.getUserObject()
    };

    logout() {
        API.logout()
            .then((resultData) => {
                localStorage.clear();
                this.props.history.push("/");
            });
    }
    render() {
        return (
            <div className="container-fluid">
                <nav className="navbar navbar-default app-header">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <button type="button"
                                className="navbar-toggle collapsed"
                                data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1"
                                aria-expanded="false">
                                <span className="sr-only">Toggle navigation</span>
                                <span className="icon-bar"></span>
                                <span className="icon-bar"></span>
                                <span className="icon-bar"></span>
                            </button>
                            <a className="navbar-brand" href="/dashboard">Freelancer</a>
                        </div>
                        <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul className="nav navbar-nav">
                                <li className="dropdown">
                                    <a href="" className="dropdown-toggle"
                                        data-toggle="dropdown"
                                        role="button"
                                        aria-haspopup="true"
                                        aria-expanded="false">Hire Freelancers <span className="caret"></span>
                                    </a>
                                    <ul className="dropdown-menu">
                                        <li><a href="">Post a Project</a></li>
                                        <li><a href="">Start a Contest</a></li>
                                        <li><a href="">Post a Local job</a></li>
                                        <li><a href="">Get Recruiter</a></li>
                                        <li role="separator" className="divider">DISCOVER</li>
                                        <li><a href="">Showcase</a></li>
                                        <li><a href="">Browse Directory</a></li>
                                        <li><a href="">Community</a></li>
                                    </ul>
                                </li>
                                <li className="dropdown">
                                    <a href="" className="dropdown-toggle"
                                        data-toggle="dropdown"
                                        role="button"
                                        aria-haspopup="true"
                                        aria-expanded="false">Work <span className="caret"></span></a>
                                    <ul className="dropdown-menu">
                                        <Link to="/listprojects">
                                            <button
                                                className="btn-link menu-items"
                                                type="button">Browse Projects
                                                </button>
                                        </Link>
                                        <Link to="">
                                            <button
                                                className="btn-link menu-items"
                                                type="button">Browse Contests
                                                </button>
                                        </Link>
                                        <Link to="">
                                            <button
                                                className="btn-link menu-items"
                                                type="button">Browse Local Jobs
                                                </button>
                                        </Link>
                                        <Link to="">
                                            <button
                                                className="btn-link menu-items"
                                                type="button">Browse Categories
                                                </button>
                                        </Link>
                                    </ul>
                                </li>
                                <li className="dropdown">
                                    <a href="" className="dropdown-toggle"
                                        data-toggle="dropdown"
                                        role="button"
                                        aria-haspopup="true"
                                        aria-expanded="false">My Projects <span className="caret"></span></a>
                                    <ul className="dropdown-menu">
                                        <li><a href="">My Projects</a></li>
                                        <li><a href="">Dashboard</a></li>
                                        <li><a href="">Inbox</a></li>
                                        <li><a href="">Feedback</a></li>
                                    </ul>
                                </li>
                                <li className="dropdown">
                                    <a href="" className="dropdown-toggle"
                                        data-toggle="dropdown"
                                        role="button"
                                        aria-haspopup="true"
                                        aria-expanded="false">Help<span className="caret"></span></a>
                                    <ul className="dropdown-menu">
                                        <li><a href="">Get Support</a></li>
                                        <li><a href="">How Freelancer.com works</a></li>
                                        <li><a href="">Frequently Asked Questions</a></li>
                                        <li><a href="">Fees and Charges</a></li>
                                        <li><a href="">Disputes</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <div>
                                <form className="navbar-form navbar-left" role="search">
                                    <div className="form-group">
                                        <input type="text" className="form-control" placeholder="Search" />
                                    </div>
                                    <button type="submit" className="btn btn-default">Submit</button>
                                </form>

                                <ul className="nav navbar-nav navbar-right">
                                    {this.state.user !== null && this.state.user.role === 1 &&
                                        <li>
                                            <Link to="/post-project" className="pd-0">
                                                <button
                                                    className="btn btn-small post-project"
                                                    type="button"
                                                >Post a Project
                                                </button>
                                            </Link>
                                        </li>
                                    }
                                    <li className="dropdown">
                                        <a href="" className="dropdown-toggle"
                                            data-toggle="dropdown"
                                            role="button"
                                            aria-haspopup="true"
                                            aria-expanded="false">$0.00 USD<span className="caret"></span></a>
                                        <ul className="dropdown-menu">
                                            <li><a href="">Financial Dashboard</a></li>
                                            <li><a href="">Transaction History</a></li>
                                            <li><a href="">Verify Payment Method</a></li>
                                            <li><a href="">Withdraw Money</a></li>
                                            <li><a href="">Redeem Coupon</a></li>
                                        </ul>
                                    </li>
                                    <li><a href=""><i className="fas fa-comment message-icon"></i></a></li>
                                    <li><a href=""><i className="fas fa-bell message-icon"></i></a></li>
                                    <li><a href=""><i className="fas fa-rss-square message-icon"></i></a></li>
                                    <li><a href=""><i className="fas fa-th message-icon"></i></a></li>
                                    <li className="dropdown">
                                        <a href="" className="dropdown-toggle"
                                            data-toggle="dropdown"
                                            role="button"
                                            aria-haspopup="true"
                                            aria-expanded="false">
                                            <i className="fas fa-user message-icon"></i>
                                            &nbsp;<span>{this.state.user !== null && this.state.user.first_name}</span>
                                            <span className="caret"></span>
                                        </a>
                                        <ul className="dropdown-menu">
                                            <Link to="/editprofile">
                                                <button
                                                    className="btn-link menu-items"
                                                    type="button"
                                                >Update Profile
                                                </button>
                                            </Link>
                                            <a href="/" onClick={() => {
                                                this.logout();
                                            }}><button className="btn-link menu-items"
                                                type="button">Logout</button></a>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        );
    }
}

export default MainHeader;