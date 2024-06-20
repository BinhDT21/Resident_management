import { useContext } from "react";
import { Navigate } from "react-router-dom";
import { UserContext } from "../../configs/Contexts";
import { Header } from "../Common/Header";
import Slide from "./Slide";

const Home = () => {
    const user = useContext(UserContext)

    if (user === null)
        return <Navigate to="/login"/>
    
    if(user.avatar === null || user.avatar === '')
        return <Navigate to="/update"/>

    return (
        <>
            <Header/>
            <Slide/>
        </>
    );
}

export default Home;