import { useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import { loginUser } from "../services/authService";
import { useDispatch, useSelector } from "react-redux";
import { onLogin, onLogout } from "../../store/slices/auth/authSlice";


export const useAuth = () => {

    const dispatch = useDispatch();
    const { user, isAdmin, isAuth, name, roles } = useSelector(state => state.auth);

    // const [login, dispatch] = useReducer(loginReducer, initialLogin);
    const navigate = useNavigate();

    const handlerLogin = async ({ email, password }) => {

        try {

            const response = await loginUser({ email, password });
            const token = response.data.token;
            console.log(token);

            const claims = JSON.parse(window.atob(token.split(".")[1]));
            const name = claims.name;
            const rolesArray = Array.isArray(claims.roles) ? claims.roles : [];
            console.log(name, roles);

            dispatch(onLogin({ user, isAdmin: claims.isAdmin }));

            sessionStorage.setItem('login', JSON.stringify({
                isAuth: true,
                name: name,
                roles: rolesArray,
                user,
            }));
            sessionStorage.setItem('token', `Bearer ${token}`);
            console.log('checking login login', sessionStorage.getItem('login'));
            navigate('/');
        } catch (error) {
            if (error.response?.status === 401) {
                Swal.fire('Error Login', 'Username o password invalidos', 'error');
            } else if (error.response?.status === 403) {
                Swal.fire('Error Login', 'No tiene acceso al recurso o permisos!', 'error');
            } else {
                throw error;
            }
        }
    }

    const handlerLogout = () => {
        dispatch(onLogout());
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('login');
        sessionStorage.clear();
    }
    return {
        login: {
            user,
            isAdmin,
            isAuth,
            name,
            roles,
        },
        handlerLogin,
        handlerLogout,
    }
}