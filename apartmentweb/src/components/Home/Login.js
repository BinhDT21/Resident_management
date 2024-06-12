import { useContext, useState } from "react"
import { Button, Form } from "react-bootstrap"
import { Navigate, useNavigate } from "react-router-dom";
import { DispatchContext, UserContext } from "../../configs/Contexts";
import APIs, { authApi, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";


const Login = () => {
    const styles = {
        container_login: {
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            height: "100vh",
            backgroundImage: "url('https://ttcland.vn/pictures/catalog/panomax-river-villa/04-Hnh-nh-nhn-mt-ngi-thy-view-b-sng.jpg')",
        },
        container_form_login: {
            width: "350px",
            justifyContent: "center",
            alignItems: "center",
            backgroundColor: "#f8f9fa",
            border: "1px solid #D0D5D9",
            borderRadius: 14,
            padding: 10
        },

    }
    const [user, setUser] = useState({})
    const dispatch = useContext(DispatchContext)
    const currentUser = useContext(UserContext)
    const nav = useNavigate();


    const change = (event, field) => {
        setUser(current => {
            return { ...current, [field]: event.target.value }
        })
    }


    const login = async (e) => {
        e.preventDefault()
        try {
            let res = await APIs.post(endpoints['login'], { ...user });
            cookie.save("token", res.data);

            setTimeout(async () => {
                let u = await authApi().get(endpoints['current-user'])
                console.info(u.data)
                dispatch({
                    "type": "login",
                    "payload": u.data
                })
            }, 100)
            nav("/")
        } catch (ex) {
            console.error(ex)
        }
    }

    if (currentUser !== null)
        return <Navigate to="/" />


    return (
        <>
            <div style={styles.container_login}>

                <div style={{ alignItems: "center", alignContent: "center" }}>
                    <div style={styles.container_form_login}>
                        <h4 className="text-center  mt-3 mb-3">Vui lòng đăng nhập</h4>
                        <Form onSubmit={login}>
                            <Form.Group className="mb-3" controlId="username">
                                <Form.Label>Tên đăng nhập</Form.Label>
                                <Form.Control onChange={e => change(e, "username")} value={user["username"]} type="text" placeholder="username" />
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="password">
                                <Form.Label>Mật khẩu</Form.Label>
                                <Form.Control onChange={e => change(e, "password")} value={user["password"]} type="password" placeholder="password" />
                            </Form.Group>
                            <div className="d-flex justify-content-center">
                                <Button variant="primary" type="submit" className="mb-1 mt-1 ">Đăng nhập</Button>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>
        </>
    )
}
export default Login