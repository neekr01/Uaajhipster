import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './quote.reducer';
import { IQuote } from 'app/shared/model/quotes/quote.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IQuoteDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class QuoteDetail extends React.Component<IQuoteDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { quoteEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Quote [<b>{quoteEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="symbol">Symbol</span>
            </dt>
            <dd>{quoteEntity.symbol}</dd>
            <dt>
              <span id="price">Price</span>
            </dt>
            <dd>{quoteEntity.price}</dd>
            <dt>
              <span id="lastTrade">Last Trade</span>
            </dt>
            <dd>
              <TextFormat value={quoteEntity.lastTrade} type="date" format={APP_DATE_FORMAT} />
            </dd>
          </dl>
          <Button tag={Link} to="/quote" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/quote/${quoteEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ quote }: IRootState) => ({
  quoteEntity: quote.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(QuoteDetail);
