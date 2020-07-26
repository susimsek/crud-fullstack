import axios from "axios";

const getAll = () => {
    return axios.get("/api/versions/1/tutorials");
};

const get = id => {
    return axios.get(`/api/versions/1/tutorials/${id}`);
};

const create = data => {
    return axios.post("/api/versions/1/tutorials", data);
};

const update = (id, data) => {
    return axios.put(`/api/versions/1/tutorials/${id}`, data);
};

const remove = id => {
    return axios.delete(`/api/versions/1/tutorials/${id}`);
};

const removeAll = () => {
    return axios.delete(`/api/versions/1/tutorials`);
};

const findByTitle = title => {
    return axios.get(`/api/versions/1/tutorials?title=${title}`);
};

export default {
    getAll,
    get,
    create,
    update,
    remove,
    removeAll,
    findByTitle
};