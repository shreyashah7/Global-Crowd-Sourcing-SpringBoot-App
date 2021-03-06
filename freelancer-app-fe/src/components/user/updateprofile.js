import React, { Component } from 'react';
import './updateprofile.css';
import * as API from '../../api/API';
import * as UserHelper from '../_helper/helper';
import { ToastContainer, toast } from 'react-toastify';
import userImage from './user.png' // relative path to image 
import { Typeahead } from 'react-bootstrap-typeahead';
import 'react-bootstrap-typeahead/css/Typeahead.css';
const _ = require('lodash');

class UserProfile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            file: '',
            imagePreviewUrl: '',
            first_name: '',
            last_name: '',
            phone_number: '',
            email: '',
            about_me: '',
            submitted: false,
            skills: '',
            defaultSkills: [],
            skillList: [],
            user: {}
        };
    }

    notify = (message) => toast(message);

    _handleImageChange(e) {
        e.preventDefault();

        let reader = new FileReader();
        let file = e.target.files[0];

        reader.onloadend = () => {
            this.setState({
                file: file,
                imagePreviewUrl: reader.result
            });
        }
        reader.readAsDataURL(file)
    }

    convertUserToState(user) {
        if (!!user.avatar) {
            user.avatar = user.avatar;
        } else {
            user.avatar = "";
        }
        this.setState({
            first_name: user.first_name,
            last_name: user.last_name,
            phone_number: !!user.phone_number ? user.phone_number : '',
            email: user.email,
            about_me: user.about_me ? user.about_me : '',
            imagePreviewUrl: user.avatar,
            defaultSkills: !!user.skills ? user.skills.split(',') : '',
            skills: !!user.skills ? user.skills : '',
            user: user
        })
    }

    convertStateToUser() {
        let userObj = this.state.user;
        userObj.first_name = this.state.first_name;
        userObj.last_name = this.state.last_name;
        userObj.phone_number = this.state.phone_number;
        userObj.about_me = this.state.about_me;
        userObj.avatar = this.state.imagePreviewUrl;
        userObj.skills = this.state.skills.toString();
        this.setState({
            user: userObj
        })

    }

    componentDidMount() {
        var user = UserHelper.getUserObject();
        if (!!user) {
            API.getUserDetails(user.id)
                .then((resultData) => {
                    if (resultData.data !== undefined && resultData.data !== null) {
                        this.convertUserToState(resultData.data);
                    } else {
                        console.log("No User Details available in DB");
                    }
                }).then(() => {
                    API.getSkills()
                        .then((resultData) => {
                            if (!!resultData.data && resultData.data.length > 0) {
                                this.setState({
                                    skillList: _.map(resultData.data, 'skill_name')
                                });
                            } else {
                                console.log("No skills available in DB");
                            }
                        }).catch(error => {
                            this.notify(error.message);
                        });
                }).catch(error => {
                    this.notify(error.message);
                });
            ;
        }
    }

    saveProfile() {
        this.setState({ submitted: true });
        if (!!this.state.user.first_name && !!this.state.last_name && !!this.state.skills && this.state.skills.length > 0) {
            this.convertStateToUser();
            API.updateUser(this.state.user.id, this.state.user)
                .then((resultData) => {
                    if (!!resultData.data) {
                        this.convertUserToState(resultData.data);
                        this.notify(resultData.meta.message);
                    } else {
                        this.notify("There is some issue with updating your profile.");
                    }
                }).catch(error => {
                    this.notify(error.message);
                });
        }
    }

    resetProfile() {
        this.convertUserToState(this.state.user);
    }

    render() {
        let imagePreviewUrl = this.state.imagePreviewUrl;
        return (
            <div>
                <div className="row main-body">
                    <div className="col-md-offset-1 col-md-10 mr-top-50">
                        <div className="profile-nav col-md-4">
                            <div className="panel">
                                <div className="user-heading round">
                                    {imagePreviewUrl &&
                                        <img src={imagePreviewUrl} alt="avatar" />
                                    }
                                    {!imagePreviewUrl &&
                                        <img src={userImage} alt="avatar" />
                                    }
                                    <div className="col-md-12">
                                        <label className="mr-t-5">
                                            <i className="fas fa-camera fs-25 cursor-pointer"></i><input type="file" hidden onChange={(e) => this._handleImageChange(e)} />
                                        </label>
                                    </div>
                                    <h1>{this.state.first_name} {this.state.last_name}</h1>
                                    <p>{this.state.email}</p>
                                </div>
                                <ul className="nav nav-pills nav-stacked">
                                    <li><a><i className="fa fa-user"></i> Profile</a></li>
                                    <li><a> <i className="fa fa-info-circle"></i> About</a></li>
                                    <li className="active"><a> <i className="fa fa-edit"></i> Edit profile</a></li>
                                </ul>
                            </div>
                        </div>
                        <div className="profile-info col-md-8">
                            <div className="widget post panel-shadow animated fadeInUp">
                                <div className="widget-header">
                                    <h3 className="widget-caption">Edit Information</h3>
                                </div>
                                <div className="widget-body">
                                    <div className="form-group clearfix">
                                        <label className="col-md-3 control-label">First name</label>
                                        <div className="col-md-8">
                                            <div className={(this.state.submitted && !this.state.first_name ? ' has-error' : '')}>
                                                <input className="form-control"
                                                    type="text"
                                                    value={this.state.first_name}
                                                    onChange={(event) => {
                                                        this.setState({
                                                            first_name: event.target.value
                                                        });
                                                    }} />
                                                {this.state.submitted && !this.state.first_name &&
                                                    <div className="help-block">First Name is required</div>
                                                }
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group clearfix">
                                        <label className="col-md-3 control-label">Last name</label>
                                        <div className="col-md-8">
                                            <div className={(this.state.submitted && !this.state.last_name ? ' has-error' : '')}>
                                                <input className="form-control"
                                                    type="text"
                                                    value={this.state.last_name}
                                                    onChange={(event) => {
                                                        this.setState({
                                                            last_name: event.target.value
                                                        });
                                                    }} />
                                                {this.state.submitted && !this.state.last_name &&
                                                    <div className="help-block">Last Name is required</div>
                                                }
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group clearfix">
                                        <label className="col-md-3 control-label">Email</label>
                                        <div className="col-md-8">
                                            <div className={(this.state.submitted && !this.state.email ? ' has-error' : '')}>
                                                <input className="form-control"
                                                    type="text"
                                                    readOnly={true}
                                                    value={this.state.email}
                                                    onChange={(event) => {
                                                        this.setState({
                                                            email: event.target.value
                                                        });
                                                    }} />
                                                {this.state.submitted && !this.state.email &&
                                                    <div className="help-block">Email is required</div>
                                                }
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group clearfix">
                                        <label className="col-md-3 control-label">Phone Number</label>
                                        <div className="col-md-8">
                                            <input className="form-control"
                                                type="text"
                                                value={this.state.phone_number}
                                                onChange={(event) => {
                                                    this.setState({
                                                        phone_number: event.target.value
                                                    });
                                                }} />
                                        </div>
                                    </div>
                                    <div className="form-group clearfix">
                                        <label className="col-md-3 control-label">About Me</label>
                                        <div className="col-md-8">
                                            <textarea className="form-control" rows="5"
                                                value={this.state.about_me}
                                                onChange={(event) => {
                                                    this.setState({
                                                        about_me: event.target.value
                                                    });
                                                }}
                                            ></textarea>
                                        </div>
                                    </div>
                                    <div className="form-group clearfix">
                                        <label className="col-md-3 control-label">Skills</label>
                                        <div className="col-md-8">
                                            <div className={(this.state.submitted && !!this.state.skills && this.state.skills.length === 0 ? ' has-error' : '')}>
                                                <Typeahead
                                                    multiple
                                                    clearButton
                                                    selected={this.state.defaultSkills}
                                                    onChange={(selected) => {
                                                        this.setState({
                                                            skills: selected
                                                        })
                                                    }}
                                                    options={this.state.skillList}
                                                /><br />
                                                <p>Suggested skills:  Website Design , Logo Design , Mobile App Development , Data Entry , Article Writing</p>
                                                {this.state.submitted && !!this.state.skills && this.state.skills.length === 0 &&
                                                    <div className="help-block">Skills is required</div>
                                                }
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group clearfix">
                                        <button type="button"
                                            onClick={() => this.saveProfile(this.state)}
                                            className="btn btn-default post-project mrt0 mr-left-10">Save Changes</button>
                                        <button type="button"
                                            onClick={() => this.resetProfile()}
                                            className="btn btn-info">Cancel Changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <ToastContainer />
            </div>
        );
    }
}

export default UserProfile;