import { Fragment, useContext, useEffect, useState } from "react";
import { Footer } from "../Common/Footer";
import { Header } from "../Common/Header";
import { UserContext } from "../../configs/Contexts";
import APIs, { endpoints } from "../../configs/APIs";
import { Alert, Button, Table } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";

const Surveys = () => {
    const styles = {
        container: {
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            height: "100vh",
            backgroundImage: "url('https://ttcland.vn/pictures/catalog/bg-menu-1.jpg')",
        },
        container_child: {
            width: "90vw",
            height: "70vh",
            backgroundColor: "#f8f9fa",
            border: "1px solid #D0D5D9",
            borderRadius: 14,
            padding: 10,
            overflowY: "scroll",

        },
    }

    const user = useContext(UserContext)
    const [surveys, setSurveys] = useState([])

    const loadSurveys = async () => {
        try {
            const res = await APIs.get(endpoints['surveys'])
            setSurveys(res.data)
        } catch (ex) {
            console.error(ex)
        }
    }
    useEffect(() => {
        loadSurveys()
    }, [])

    if (user === null)
        return <Navigate to="/login" />

    return (
        <>
            <Header />
            <div style={styles.container}>
                <div style={styles.container_child}>
                    <Alert variant="info">&#10071; Cư dân vui lòng thực hiện khảo sát đầy đủ !</Alert>
                    <Table bordered size="xl">
                        <tr style={{ height: "50px" }}>
                            <th style={{ paddingLeft: "100px" }}>Id</th>
                            <th>Tên khảo sát</th>
                            <th>Ngày bắt đầu</th>
                            <th></th>
                        </tr>
                        {surveys.map(i => <Fragment key={i.id}>
                            <tr style={{ height: "70px" }}>
                                <td style={{ paddingLeft: "100px" }}>{i.id}</td>
                                <td>{i.title}</td>
                                <td>{i.createdDate}</td>
                                <td>
                                    <Link to={`/surveys/${i.id}/`} className="btn btn-info">Thực hiện khảo sát</Link>
                                </td>
                            </tr>
                        </Fragment>)}
                    </Table>
                </div>
            </div>
            <Footer />
        </>
    )
}
export default Surveys;