import React, {Component} from 'react';
import {Form, Icon, Input, Button, Checkbox} from "antd";
import "antd/dist/antd.css";

class NormalLoginForm extends Component{
    constructor(props) {
        super(props);
        this.state = {
          loginFlag: false
        };
        this.handlesubmit = this.handlesubmit.bind(this);
      }
      handlesubmit() {
        this.props.form.validateFields((err, values) => {
          if (!err) {
            let userinfo = this.props.form.getFieldsValue();
            if (userinfo.username == "admin" && userinfo.password == "123456") {
              alert("登录成功，正在跳转应用界面!");
              this.setState({
                loginFlag: true
              });
            } else {
              alert("账号或密码错误，请重新输入!");
              window.location.reload(true);
            }
          }
        });
      }
      render() {
        const { getFieldDecorator } = this.props.form;
        if (this.state.loginFlag) {
          this.props.history.push('/weather');
        }
        return (
          <div className="login">
            <h1 className="text">Login In</h1>
            <br></br>
            <Form onSubmit={this.handlesubmit} className="login-form">
              <Form.Item>
                {getFieldDecorator("username", {
                  rules: [
                    { required: true, message: "'Please input your username!'" }
                  ]
                })(
                  <Input
                    prefix={
                      <Icon type="user" style={{ color: "rgba(0,0,0,.25)" }} />
                    }
                    placeholder="Username"
                  />
                )}
              </Form.Item>
              <Form.Item>
                {getFieldDecorator("password", {
                  rules: [
                    { required: true, message: "Please input your Password!" }
                  ]
                })(
                  <Input
                    prefix={
                      <Icon type="lock" style={{ color: "rgba(0,0,0,.25)" }} />
                    }
                    type="password"
                    placeholder="Password"
                  />
                )}
              </Form.Item>
              <Form.Item>
                {getFieldDecorator("remember", {
                  valuePropName: "checked",
                  initialValue: true
                })(<Checkbox>Remember me</Checkbox>)}
                <a className="login-form-forgot" href="">
                  Forgot password
                </a>
                <Button
                  type="primary"
                  htmlType="submit"
                  className="login-form-button"
                >
                  Log in
                </Button>
              </Form.Item>
            </Form>
          </div>
        );
    }
}


const Login = Form.create({ name: 'normal_login' })(NormalLoginForm);

export default Login;