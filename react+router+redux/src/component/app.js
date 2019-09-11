import React, {Component} from 'react';
import {HashRouter, Switch, Route, Link} from 'react-router-dom';
import {Layout, Menu, Icon} from 'antd';

import login from './page/login';
import weather from './page/weather';
import news from './page/news';
import translate from './page/translate';
import personselect from './page/personselect';


const {Header, Content, Sider } = Layout;
class App extends Component{
    constructor(props){
        super(props);
        this.state = {
            collapsed: false
        };
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            collapsed: !this.state.collapsed
        });
    }

    render(){
        return <HashRouter>
            <Switch>
                <Route exact path="/" component={login}></Route>
                <Layout>
                    <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
                        <Menu theme="dark">
                            <Menu.Item key="1">
                                <Icon type="ant-cloud" />
                                <span>天气查询</span>
                                <Link to="/weather" />
                            </Menu.Item>
                            <Menu.Item key="2">
                                <Icon type="book" />
                                <span>新闻查询</span>
                                <Link to="/news" />
                            </Menu.Item>
                            <Menu.Item key="3">
                                <Icon type="sync" />
                                <span>中英翻译</span>
                                <Link to="/translate" />
                            </Menu.Item>
                            <Menu.Item key="4">
                                <Icon type="search" />
                                <span>人员查询</span>
                                <Link to="/personselect" />
                            </Menu.Item>
                        </Menu>
                    </Sider>
                    <Layout>
                        <Header style={{background: "#fff", padding: 0 }}>
                            <Icon className="trigger" type={this.state.collapsed ? "menu-unfold" : "menu-fold"} onClick={this.toggle} />
                        </Header>
                        <Content style={{margin:"24px 16px", padding:24, background:"#fff", minHeight:280}}>                        
                                <Route path="/weather" exact component={weather} />
                                <Route path="/news" component={news} />
                                <Route path="/translate" component={translate} />
                                <Route path="/personselect" component={personselect} />        
                        </Content>
                    </Layout>
                </Layout>
            </Switch>
        </HashRouter>

    }
}

export default App;