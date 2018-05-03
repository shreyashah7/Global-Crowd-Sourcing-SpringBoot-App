import React, { Component } from 'react';
import ReactTable from 'react-table';
import 'react-table/react-table.css';
import * as API from '../../api/API';
import { Link } from 'react-router-dom';
const Timestamp = require('react-timestamp');

class ListProject extends Component {

    constructor(props) {
        super(props);

        this.state = {
            projectList: []
        };
    }

    componentDidMount() {
        API.getOpenProjects()
            .then((resultData) => {
                if (!!resultData.data) {
                    this.setState({
                        projectList: resultData.data
                    });
                } else {
                    console.log("There are no open projects in DB");
                }
            });
    }

    render() {
        const columns = [{
            Header: 'OPEN PROJECT',
            accessor: 'project_name',
            width: 800,
            style: { 'whiteSpace': 'unset' },
            Cell: props => (<div><i className="fas fa-tv project-name"></i><Link to={'/viewproject/' + props.row._original.id}>
                <button
                    className="btn-link project-name"
                    type="button"
                ><b>{props.row._original.project_name}</b>
                </button>
            </Link>
                <br />
                <br />
                <span>{props.row._original.description}</span>
                <br />
                <br />
                <a>Skills: {props.row._original.skills}</a>
            </div>)
        }, {
            Header: 'BIDS/ENTRIES',
            accessor: 'bid_count',
            style: { 'textAlign': 'right' },
        }, {
            Header: 'STARTED',
            accessor: 'created_at',
            style: { 'textAlign': 'right' },
            Cell: props => <span className='number'><Timestamp time={props.value} format='date' /></span>
        }, {
            Header: 'PRICE (USD)',
            accessor: 'job_rate',
            style: { 'textAlign': 'right' },
            Cell: props => (<span>{props.row._original.job_rate + '/' + props.row._original.job_type}</span>)
        }]
        return (
            <div className="main-body">
                <div className="col-md-offset-1 col-md-10 mr-t-50">
                    < ReactTable
                        minRows={0}
                        filterable={true}
                        data={this.state.projectList}
                        columns={columns} />
                </div>
            </div>
        )
    }

}

export default ListProject;