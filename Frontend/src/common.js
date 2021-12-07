import axios from "axios"

const axios_contact = axios.create({
    baseURL:"http://localhost:9999/hanbang",
});

export { axios_contact }