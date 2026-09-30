import {
    Card, CardImg, CardText, CardBody
} from 'reactstrap';

const Flashcard = (props) => {
    return (
        <div>
            <div className="row">
                <div className="col-md-10 col-lg-6">
                    <Card>
                        <h1 className="display-3">{props.titulo}</h1>
                        <div className="row">
                            <div className="col-md-8 col-lg-4">
                                <CardImg top width="50" src={props.imagen}/>
                            </div>
                        </div>

                        <CardBody>
                            <CardText>{props.texto}</CardText>
                        </CardBody>
                    </Card>
                    &nbsp;
                </div>
            </div>
        </div>
    );
}

export default Flashcard;