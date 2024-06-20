import { useContext, useEffect, useState } from "react";
import { Button, Container, Form, ListGroup, Modal } from "react-bootstrap";
import { Navigate } from "react-router-dom";
import { authApi, endpoints } from "../../configs/APIs";
import { UserContext } from "../../configs/Contexts";
import { Header } from "../Common/Header";
import "./CAF.css";

const Feedback = () => {
    const [showFeedback, setShowFeedback] = useState(false)
    const user = useContext(UserContext)
    const [feedback, setFeedback] = useState([])
    const [content, setContent] = useState('')

    const handleCloseFeedback = () => setShowFeedback(false);
    const handleShowFeedback = () => setShowFeedback(true);

    const sendFeedback = async (e) => {
        e.preventDefault();
        try {
            await authApi.post(endpoints['create-feedback'], {content})
            setContent('')
            await loadFeedbacks()
            handleCloseFeedback()
        } catch(err) {
            console.error('Create feedback error: ' + err)
        }
    }

    const loadFeedbacks = async () => {
        try {
            let res = await authApi.get(endpoints['feedback'])
            setFeedback(res.data)
        } catch(ex) {
            console.error("error fetching feedback", ex)
        }
    }
    

    useEffect(() => {
        if (user !== null){
            loadFeedbacks()
        }
    }, [user])

    
    if (user === null)
        return <Navigate to="/login" />

    return (
        <Container>
            <Header />
            <h1 className="text-center">Phản hồi căn hộ</h1>
            <Button onClick={handleShowFeedback}>
                Viết phản hồi
            </Button>
            
            <Modal show={showFeedback} onHide={handleCloseFeedback}>
                <Modal.Header closeButton>
                    <Modal.Title>Đóng góp ý kiến</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form className="mt-3" onSubmit={sendFeedback}>
                        <Form.Group controlId="formFeedback">
                            <Form.Label>Ý kiến của bạn</Form.Label>
                            <Form.Control
                                required
                                as="textarea"
                                rows={3}
                                placeholder="Viết ý kiến của bạn"
                                value={content}
                                onChange={(e) => setContent(e.target.value)}
                            />
                            <Form.Control.Feedback type="invalid">
                                Vui lòng nhập phản hồi của bạn
                            </Form.Control.Feedback>
                        </Form.Group>
                        <Button type="submit" className="mt-2" >Gửi phản hồi</Button>
                    </Form>
                </Modal.Body>
            </Modal>
            
            <h2 className="mt-4">Lịch sử ý kiến</h2>
                <ListGroup>
                {feedback.map((entry, index) => (
                    <ListGroup.Item className="content" key={index}
                        style={{ backgroundColor: entry.status === 0 ? "red" : "green" }}
                    >
                        <div>
                            <h5>{entry.lastName} {entry.firstName}</h5>
                            <p>{entry.content}</p>
                            <h6 className="entry-created">{entry.createdDate}</h6>
                        </div>
                    </ListGroup.Item>
                ))}
            </ListGroup>
        </Container>
    );
};

export default Feedback;
