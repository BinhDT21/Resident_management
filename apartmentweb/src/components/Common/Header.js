import { useContext } from "react"
import { Button, Image, Nav, NavDropdown, Navbar } from "react-bootstrap"
import { Link } from "react-router-dom"
import { DispatchContext, UserContext } from "../../configs/Contexts"

export const Header = () => {
    const dispatch = useContext(DispatchContext)
    const user = useContext(UserContext)


    return (
        <Navbar bg="light" data-bs-theme="light" expand="lg" className="bg-body-tertiary">

            <Navbar.Brand>
                <Image src="https://res.cloudinary.com/dwdvnztnn/image/upload/v1716542240/2_k3qyxl.png" roundedCircle width="100" height="100" />
            </Navbar.Brand>
            <Link to="/" className="nav-link">BK Apartment</Link>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <NavDropdown title="Tiện ích" id="basic-nav-dropdown">
                        <Link to="/" className="nav-link">Thanh toán hóa đơn</Link>
                        <Link to="/visitor_card" className="nav-link">Đăng ký thẻ xe</Link>
                        <Link to="/" className="nav-link">Quản lý tủ đồ</Link>
                        <Link to="/" className="nav-link">Phản hồi</Link>
                    </NavDropdown>
                    {user && <>
                        <Link to="/" className="nav-link">Cư dân: {user.firstName} {user.lastName}</Link>
                        <Button className="ms-2" variant="primary" onClick={() => dispatch({ "type": "logout" })}>Đăng xuất</Button>
                    </>
                    }

                </Nav>
            </Navbar.Collapse>




        </Navbar>
    )
}