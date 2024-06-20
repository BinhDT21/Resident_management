import { useState } from "react";
import { Button, Container, Form, ListGroup, Modal } from "react-bootstrap";
import { Header } from "../Common/Header";
import "./Visitor.css";

const VistorCard = () => {
    const [showRegisterForm, setShowRegisterForm] = useState(false)
    const [validated, setValidated] = useState(false);
    const [registerSubmitted, setRegisterSubmitted] = useState(false)
    const [visitor, setVisitor] = useState("")
    const [history, setHistory] = useState([
        { id: 1, visitor: "Kiệt", relation: "Friend"},
        { id: 2, visitor: "Chị hàng xóm ngày xưa hay qua nhà", relation: "Friend"},
    ]);

    const handleSubmitRegister = (event) => {
        event.preventDefault();
        event.stopPropagation();

        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        } else {
            const newEntry = { visitor };
                setHistory([...history, newEntry])
                setVisitor("")
                setValidated(false)
                setShowRegisterForm(false)
                setRegisterSubmitted(true)
            };
        }

    const handleCloseRegister = () => setShowRegisterForm(false)
    const handleShowRegister = () => setShowRegisterForm(true)

    return (
        <Container>
        <Header/>
        <h1 className="text-center">Đăng ký cho người thân</h1>
        <Button onClick={handleShowRegister} className="ms-2">
            Đăng ký cho người thân
        </Button>
        <Modal show={showRegisterForm} onHide={handleCloseRegister}>
            <Modal.Header closeButton>Đăng ký cho người thân</Modal.Header>
            <Modal.Body>
                <Form noValidate validated={validated} onSubmit={handleSubmitRegister} className="mt-3">
                    <Form.Group controlId="formRegister" className="mb-3">
                        <Form.Control
                            required
                            as="textarea"
                            rows={2}
                            placeholder="Họ và tên"
                            value={visitor}
                            onChange={(e) => setVisitor(e.target.value)}
                        />
                        <Form.Label>Ảnh CCCD</Form.Label>
                        <Form.Control type="file"/>
                        <Form.Control.Feedback type="invalid">
                            Vui lòng điền họ và tên
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Button type="submit" className="mt-2">Gửi yêu cầu</Button>
                </Form>
            </Modal.Body>
        </Modal>
        <h2 className="mt-4">Lịch sử đăng ký</h2>
        <ListGroup>
            {history.map((entry, index) => (
                <ListGroup.Item
                className="visitor"
                key={index}>
                <div>
                    <p>{entry.visitor}</p>
                    <h6 className=""></h6>
                </div>
                </ListGroup.Item>
            ))}
        </ListGroup>
        </Container>
    )
}
export default VistorCard;