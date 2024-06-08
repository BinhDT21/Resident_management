import { Container, Image, Nav, Navbar } from "react-bootstrap"
import { Link } from "react-router-dom"

export const Header = () => {
    return (
        <Navbar bg="light" data-bs-theme="light" expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="/">
                        <Image src="https://res.cloudinary.com/dwdvnztnn/image/upload/v1716542240/2_k3qyxl.png" roundedCircle width="100" height="100"/>
                    </Navbar.Brand>
                    <Navbar.Brand href="/">BK Apartment</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Link to="/" className="nav-link">Thanh toán hóa đơn</Link>
                            <Link to="/visitor_card" className="nav-link">Đăng ký thẻ xe</Link>
                            <Link to="/" className="nav-link">Quản lý tủ đồ</Link>
                            <Link to="/" className="nav-link">Phản hồi</Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
    )
}