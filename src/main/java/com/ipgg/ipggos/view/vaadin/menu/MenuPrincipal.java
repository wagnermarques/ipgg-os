
package com.ipgg.ipggos.view.vaadin.menu;

import com.ipgg.ipggos.view.crudview.OrdemDeServicoListView;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListViewForDeletion;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListViewForUpdate;
import com.ipgg.ipggos.view.crudview.PessoaFormInserirView;
import com.ipgg.ipggos.view.crudview.PessoaListView;
import com.ipgg.ipggos.view.crudview.PessoaListViewForDeletion;
import com.ipgg.ipggos.view.crudview.PessoaListViewForUpdate;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioFormViewForInsertion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListView;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListViewForDeletion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListViewForUpdate;
import com.ipgg.ipggos.view.vaadin.Main;
import com.ipgg.ipggos.view.vaadin.TelaFeedBack;
import com.ipgg.ipggos.view.vaadin.TelaListaOS;
import com.ipgg.ipggos.view.vaadin.TelaSolicitacao;
import com.ipgg.ipggos.view.vaadin.ViewComponentsStateController;
//import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class MenuPrincipal {

    public static MenuBar getInstance(){
        
    	MenuBar barmenu = new MenuBar();        
        
        MenuItem mnuItemcadastro = barmenu.addItem("Cadastro", null, null);
        ViewComponentsStateController.registerMenuItem(mnuItemcadastro);
        
        MenuItem mnuOrdemDeServicos = barmenu.addItem("Ordem de Servico", null, null);
        ViewComponentsStateController.registerMenuItem(mnuOrdemDeServicos);
        
        MenuItem barItem_Ajuda = barmenu.addItem("Ajuda", null, null);
        ViewComponentsStateController.registerMenuItem(barItem_Ajuda);
        MenuItem barItem_Sobre = barItem_Ajuda.addItem("Sobre", null, null);
        ViewComponentsStateController.registerMenuItem(barItem_Sobre);
        
        
        //Itens (Nivel 1) da barra de menus
        MenuItem barItem_Crud_UsuarioDoSistema = mnuItemcadastro.addItem("Administrar Usuarios do Sistema",null,null);
        ViewComponentsStateController.registerMenuItem(barItem_Crud_UsuarioDoSistema);
        
        MenuItem barItem_Crud_OrdemDeServico = mnuItemcadastro.addItem("Administrar Ordens de Servico",null,null);
        ViewComponentsStateController.registerMenuItem(barItem_Crud_OrdemDeServico);
    
        
        MenuItem barItem_Crud_FeedBack = mnuItemcadastro.addItem("Administrar Feedbacks",null,null);
        ViewComponentsStateController.registerMenuItem(barItem_Crud_FeedBack);
        
        
        MenuItem barItem_Crud_Pessoa = mnuItemcadastro.addItem("Cadastro de Pessoas",null,null);
        ViewComponentsStateController.registerMenuItem(barItem_Crud_Pessoa);
        
        
        MenuItem mnuItem_CRIAR_FEEDBACK = barItem_Crud_FeedBack.addItem("Criar Feedback",null,null);
        mnuItem_CRIAR_FEEDBACK.setCommand((selectedItem) -> Main.navigator.navigateTo(TelaFeedBack.VIEW_NAME));
        
        
        //####### Items do menu CADASTRO
        //Sistema Usuario
        MenuItem mnuItem_UsuarioDoSistema_INSERIR = barItem_Crud_UsuarioDoSistema.addItem("Inserir (funciona)",null,null);
        mnuItem_UsuarioDoSistema_INSERIR.setCommand((selectedItem) -> Main.navigator.navigateTo(SistemaUsuarioFormViewForInsertion.VIEW_NAME));
        
        MenuItem mnuItem_UsuarioDoSistema_ALTERAR = barItem_Crud_UsuarioDoSistema.addItem("Alterar (em desenvolvimento)",null,null);
        mnuItem_UsuarioDoSistema_ALTERAR.setCommand((selecteditem) -> Main.navigator.navigateTo(SistemaUsuarioListViewForUpdate.VIEW_NAME));
        
        MenuItem mnuItem_UsuarioDoSistema_EXCLUIR = barItem_Crud_UsuarioDoSistema.addItem("Excluir (funciona)",null,null);
        mnuItem_UsuarioDoSistema_EXCLUIR.setCommand((selecteditem) -> Main.navigator.navigateTo(SistemaUsuarioListViewForDeletion.VIEW_NAME));
        
        MenuItem mnuItem_UsuarioDoSistema_PESQUISAR = barItem_Crud_UsuarioDoSistema.addItem("Pesquisar  (funciona)",null,null);
        mnuItem_UsuarioDoSistema_PESQUISAR.setCommand((selectedItem) -> Main.navigator.navigateTo(SistemaUsuarioListView.VIEW_NAME));
        
        
        //Pessoa
        MenuItem mnuItem_Pessoa_INSERIR = barItem_Crud_Pessoa.addItem("Inserir  (funciona)",null,null);
        mnuItem_Pessoa_INSERIR.setCommand((selectedItem) -> Main.navigator.navigateTo(PessoaFormInserirView.VIEW_NAME));        
        
        MenuItem mnuItem_Pessoa_ALTERAR = barItem_Crud_Pessoa.addItem("Alterar  (em desenvolvimento)",null,null);
        mnuItem_Pessoa_ALTERAR.setCommand((selectedItem) -> Main.navigator.navigateTo(PessoaListViewForUpdate.VIEW_NAME));
        
        MenuItem mnuItem_Pessoa_EXCLUIR = barItem_Crud_Pessoa.addItem("Excluir (funciona)",null,null);
        mnuItem_Pessoa_EXCLUIR.setCommand((selecteditem) -> Main.navigator.navigateTo(PessoaListViewForDeletion.VIEW_NAME));
        
        MenuItem mnuItem_Pessoa_PESQUISAR = barItem_Crud_Pessoa.addItem("Pesquisar  (funciona)",null,null);
        mnuItem_Pessoa_PESQUISAR.setCommand((selectedItem) -> Main.navigator.navigateTo(PessoaListView.VIEW_NAME));
        


        //Items do menu ORDEM DE SERVICO
        MenuItem mnuItem_OS_INSERIR = barItem_Crud_OrdemDeServico.addItem("Inserir (Testar)",null,null);
        mnuItem_OS_INSERIR.setCommand((selectedItem) -> Main.navigator.navigateTo(TelaSolicitacao.VIEW_NAME));
        
        MenuItem mnuItem_OS_ALTERAR = barItem_Crud_OrdemDeServico.addItem("Alterar (em desenvolvimento)",null,null);
        mnuItem_OS_ALTERAR.setCommand((selecteditem) -> Main.navigator.navigateTo(OrdemDeServicoListViewForUpdate.VIEW_NAME));
        
        MenuItem mnuItem_OS_EXCLUIR = barItem_Crud_OrdemDeServico.addItem("Excluir (funciona)",null,null);
        mnuItem_OS_EXCLUIR.setCommand((selecteditem) -> Main.navigator.navigateTo(OrdemDeServicoListViewForDeletion.VIEW_NAME));
        
        MenuItem mnuItem_OS_PESQUISAR = barItem_Crud_OrdemDeServico.addItem("Pesquisar  (funciona)",null,null);
        mnuItem_OS_PESQUISAR.setCommand((selectedItem) -> Main.navigator.navigateTo(OrdemDeServicoListView.VIEW_NAME));
        
        
        //### Itens do menu Ordem de Servico
        MenuItem mnuItem_minhasOs = mnuOrdemDeServicos.addItem("Minhas Ordens de Serviços",null,null);
        mnuItem_minhasOs.setCommand((selectedItem) -> Main.navigator.navigateTo(TelaListaOS.VIEW_NAME));

        MenuItem mnuItem_AbrirOrdemDeServico = mnuOrdemDeServicos.addItem("Abrir Nova Ordem de Servico",null,null);
        mnuItem_AbrirOrdemDeServico.setCommand((selectedItem) -> Main.navigator.navigateTo(TelaSolicitacao.VIEW_NAME));
        
        return barmenu;
    }
}
    
