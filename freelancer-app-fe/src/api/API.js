import * as UserHelper from '../components/_helper/helper';
const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:8080'

const headers = {
    'Accept': 'application/json'
};

export const login = (payload) =>
    fetch(`${api}/login`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const logout = (payload) =>
    fetch(`${api}/logout`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const signUp = (payload) =>
    fetch(`${api}/signup`, {
        method: 'PUT',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const getUserDetails = (payload) =>
    fetch(`${api}/user/` + payload, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const updateUser = (id, user) =>
    fetch(`${api}/user/` + id, {
        method: 'PUT',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(user)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });
export const getLoggedInUserProjects = (userInfo) =>
    fetch(`${api}/userprojects`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(userInfo)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });
export const postProject = (projectData) =>
    fetch(`${api}/project`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(projectData)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });
export const hireFreelancer = (projectData) =>
    fetch(`${api}/project`, {
        method: 'PUT',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(projectData)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });
export const getProjectById = (projectId) =>
    fetch(`${api}/project/` + projectId, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });
export const getSkills = () =>
    fetch(`${api}/skills`, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const getOpenProjects = () =>
    fetch(`${api}/projects`, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const placeBid = (userProjectInfo) =>
    fetch(`${api}/placebid`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(userProjectInfo)
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

export const getAllBidsByProject = (projectId) =>
    fetch(`${api}/bids/` + projectId, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include'
    }).then(res => {
        return successHandler(res);
    }).catch(error => {
        return error;
    });

let successHandler = (res) => {
    if (res.status === 401) {
        UserHelper.redirectToLogin();
    } else {
        return res.json();
    }
}