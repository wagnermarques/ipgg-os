
package com.ipgg.ipgg_os.view.vaadin.menu;

import com.ipgg.ipgg_os.view.crudview.PessoaFormInserirView;
import com.ipgg.ipgg_os.view.crudview.PessoaListView;
import com.ipgg.ipgg_os.view.crudview.PessoaListViewForDeletion;
import com.ipgg.ipgg_os.view.crudview.SistemaUsuarioFormViewForInsertion;
import com.ipgg.ipgg_os.view.crudview.SistemaUsuarioListView;
import com.ipgg.ipgg_os.view.crudview.SistemaUsuarioListViewForDeletion;
import com.ipgg.ipgg_os.view.crudview.SistemaUsuarioListViewForUpdate;
import com.ipgg.ipgg_os.view.vaadin.Main;

//import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar;

import com.vaadin.ui.MenuBar.MenuItem;

public class MenuPrincipal {

    public static MenuBar getInstance(){
        
    	MenuBar barmenu = new MenuBar();        
        
        MenuItem mnuItemcadastro = barmenu.addItem("Cadastro", null, null);
        MenuItem mnuOrdemDeServicos = barmenu.addItem("Ordem de Servico", null, null);
        
        //Itens (Nivel 1) da barra de menus
        MenuItem barItem_UsuarioDoSistema = mnuItemcadastro.addItem("Usuario do Sistema",null,null);
        MenuItem barItem_Pessoa = mnuItemcadastro.addItem("Pessoas",null,null);
        MenuItem barItem_Ajuda = barmenu.addItem("Ajuda", null, null);
        MenuItem barItem_Sobre = barItem_Ajuda.addItem("Sobre", null, null);
        
        
        //Items do menu CADASTRO
        //Sistema Usuario
        MenuItem mnuItem_UsuarioDoSistema_INSERIR = barItem_UsuarioDoSistema.addItem("Inserir (funciona)",null,null);
        mnuItem_UsuarioDoSistema_INSERIR.setCommand((selectedItem) -> Main.navigator.navigateTo(SistemaUsuarioFormViewForInsertion.VIEW_NAME));
        
        MenuItem mnuItem_UsuarioDoSistema_ALTERAR = barItem_UsuarioDoSistema.addItem("Alterar (em desenvolvimento)",null,null);
        mnuItem_UsuarioDoSistema_ALTERAR.setCommand((selecteditem) -> Main.navigator.navigateTo(SistemaUsuarioListViewForUpdate.VIEW_NAME));
        
        MenuItem mnuItem_UsuarioDoSistema_EXCLUIR = barItem_UsuarioDoSistema.addItem("Excluir (funciona)",null,null);
        mnuItem_UsuarioDoSistema_EXCLUIR.setCommand((selecteditem) -> Main.navigator.navigateTo(SistemaUsuarioListViewForDeletion.VIEW_NAME));
        
        MenuItem mnuItem_UsuarioDoSistema_PESQUISAR = barItem_UsuarioDoSistema.addItem("Pesquisar  (funciona)",null,null);
        mnuItem_UsuarioDoSistema_PESQUISAR.setCommand((selectedItem) -> Main.navigator.navigateTo(SistemaUsuarioListView.VIEW_NAME));
        
        //Pessoa
        MenuItem mnuItem_Pessoa_INSERIR = barItem_Pessoa.addItem("Inserir  (funciona)",null,null);
        mnuItem_Pessoa_INSERIR.setCommand((selectedItem) -> Main.navigator.navigateTo(PessoaFormInserirView.VIEW_NAME));        
        MenuItem mnuItem_Pessoa_ALTERAR = barItem_Pessoa.addItem("Alterar  (em desenvolvimento)",null,null);
        MenuItem mnuItem_Pessoa_EXCLUIR = barItem_Pessoa.addItem("Excluir (funciona)",null,null);
        mnuItem_Pessoa_EXCLUIR.setCommand((selecteditem) -> Main.navigator.navigateTo(PessoaListViewForDeletion.VIEW_NAME));
        
        MenuItem mnuItem_Pessoa_PESQUISAR = barItem_Pessoa.addItem("Pesquisar  (funciona)",null,null);
        mnuItem_Pessoa_PESQUISAR.setCommand((selectedItem) -> Main.navigator.navigateTo(PessoaListView.VIEW_NAME));
        


        //Items do menu ORDEM DE SERVICO
        //Sistema Usuario
        MenuItem mnuItem_OS_INSERIR = barItem_UsuarioDoSistema.addItem("Inserir (funciona)",null,null);
        mnuItem_OS_INSERIR.setCommand((selectedItem) -> Main.navigator.navigateTo(OrdemDeServicoFormViewForInsertion.VIEW_NAME));
        
        MenuItem mnuItem_OS_INSERIR_ALTERAR = barItem_UsuarioDoSistema.addItem("Alterar (em desenvolvimento)",null,null);
        mnuItem_OS_ALTERAR.setCommand((selecteditem) -> Main.navigator.navigateTo(OrdemDeServicoListViewForUpdate.VIEW_NAME));
        
        MenuItem mnuItem_OS_EXCLUIR = barItem_UsuarioDoSistema.addItem("Excluir (funciona)",null,null);
        mnuItem_OS_EXCLUIR.setCommand((selecteditem) -> Main.navigator.navigateTo(OrdemDeServicoListViewForDeletion.VIEW_NAME));
        
        MenuItem mnuItem_OS_PESQUISAR = barItem_UsuarioDoSistema.addItem("Pesquisar  (funciona)",null,null);
        mnuItem_OS_PESQUISAR.setCommand((selectedItem) -> Main.navigator.navigateTo(OrdemDeServicoListView.VIEW_NAME));
        
        return barmenu;
    }
}
    
