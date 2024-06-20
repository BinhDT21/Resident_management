import { Container, ListGroup } from "react-bootstrap";
import { Header } from "../Common/Header";
import InvoiceDetails from "./InvoiceDetails";
import "./Payment.css";

const Invoice = () => {
    const invoices = [
        { name: "Hóa đơn số 1", details: "Chi tiết hóa đơn số 1" },
        { name: "Hóa đơn số 2", details: "Chi tiết hóa đơn số 2" },
        { name: "Hóa đơn số 3", details: "Chi tiết hóa đơn số 3" },
        { name: "Hóa đơn số 4", details: "Chi tiết hóa đơn số 4" },
        { name: "Hóa đơn số 5", details: "Chi tiết hóa đơn số 5" }
    ];

    return (
        <Container>
            <Header />
            <h1 className="text-center">Hóa đơn thanh toán</h1>
            <ListGroup>
                {invoices.map((invoice, index) => (
                    <InvoiceDetails
                        key={index}
                        name={invoice.name}
                        details={invoice.details}
                        isOdd={index % 2 === 0}
                    />
                ))}
            </ListGroup>
        </Container>
    );
};

export default Invoice;
