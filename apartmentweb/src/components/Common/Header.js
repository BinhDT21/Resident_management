import { useContext } from "react"
import { Button, Container, Image, Nav, NavDropdown, Navbar } from "react-bootstrap"
import { Link } from "react-router-dom"
import { DispatcherContext, UserContext } from "../../configs/Contexts"
import "./Common.css"

export const Header = () => {
    const dispatch = useContext(DispatcherContext);
    const user = useContext(UserContext)

    return (
        <Navbar bg="light" data-bs-theme="light" expand="lg" className="bg-body-tertiary">
            <Container>
            <Navbar.Brand href="/">
                <Image className="icon " src="https://res.cloudinary.com/dwdvnztnn/image/upload/v1716542240/2_k3qyxl.png"/>
                <Navbar.Brand href="/">BK Apartment</Navbar.Brand>
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link to="/" className="nav-link">Trang chủ</Link>
                        <Link to="/invoice" className="nav-link">Hóa đơn</Link>
                        <NavDropdown title="Tiện ích" id="basic-nav-dropdown">
                            <NavDropdown.Item><Link to="/visitor_card" className="nav-link">Đăng ký người thân</Link></NavDropdown.Item>
                            <NavDropdown.Item><Link to="/feedback" className="nav-link">Đóng góp ý kiến</Link></NavDropdown.Item>
                            <NavDropdown.Item><Link to="/survey" className="nav-link">Khảo sát</Link></NavDropdown.Item>
                        </NavDropdown>

                        {user && <>
                        <Link to="/" className="nav-link">Cư dân: {user.firstName} {user.lastName}</Link>
                        <Button className="ms-2" variant="primary" onClick={() => dispatch({ "type": "logout" })}>Đăng xuất</Button>
                        </>
                        }
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}