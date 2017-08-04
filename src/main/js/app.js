'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const $ = require('jquery');

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {customers: [], pageSize: 1, links: {}, page:{}};
    }

    loadFromServer(pageSize) {
        var app = this;
        $.get('/api/customers?page=0&size=' + pageSize, function(data) {
            app.setState({customers: data._embedded.customers});
            app.setState({links: data._links});
            app.setState({links: data.page});
        });
    }

    componentDidMount() {
        this.loadFromServer(this.state.pageSize);
    }

    render() {
        return (
            <CustomerList customers={this.state.customers}/>
        )
    }
}
class CustomerList extends React.Component {
    render() {
        var customers = this.props.customers.map(
            customer => <Customer key={customer._links.self.href} customer={customer}/>
        );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                    {customers}
                </tbody>
            </table>
        )
    }
}
class Customer extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.customer.firstName}</td>
                <td>{this.props.customer.lastName}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App/>, document.getElementById('react')
);

class CreateDialog extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleSubmit(e) {
        e.preventDefault();
        var something = {};
        this.props.attributes.forEach(attribute => {
            something[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
        });
        this.props.onCreate(something);
        
        //clear out input
        this.props.attributes.forEach(attribute => {
            ReactDOM.findDOMNode(this.refs[attribute]).value = '';
        });

        //navigate away to hide dialog
        window.location = "#";
    }
    render() {
        var inputs = this.props.attributes.map(attribute => {
            <p key={attribute}>
                <input type="text" placeholder={attribute} ref={attribute} className="field"/>
            </p>
        });

        return (
            <div>
                <a href="#createSomething">Create Something</a>
                <div id="createSomething" className="modalDialog">
                    <div>
                        <a href="#" title="Close" className="close">X</a>
                        <h2>Create new Something</h2>
                        <form>
                            {inputs}
                            <button onClick={this.handleSubmit}>Create</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
};