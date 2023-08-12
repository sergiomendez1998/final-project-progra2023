import { Navigate, Route, Routes } from "react-router-dom"
import { Navbar } from "../components/layout/Navbar"
import { RegisterPage } from "../pages/RegisterPage"
import { UsersPage } from "../pages/UsersPage"
import { useSelector } from "react-redux"
import {Header} from "../components/layout/Header.jsx";
import {Menu} from "../components/layout/Menu.jsx";
import {Dashboard} from "../components/layout/Dashboard.jsx";
import {Footer} from "../components/layout/Footer.jsx";
import {RegistrationFormView} from "../components/RegistrationFormView.jsx";

export const UserRoutes = () => {
    const { isAdmin } = useSelector(state => state.auth);
    return (
        <>
            <div className="wrapper">
                <Header/>
                <Menu/>
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/cardsView" element={<RegistrationFormView />} />
                </Routes>
                <Footer/>
            </div>
        </>
    )
}