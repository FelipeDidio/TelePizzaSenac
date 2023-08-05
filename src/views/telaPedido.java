/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Item;
import models.Pedido;

/**
 *
 * @author 180701103
 */
public class telaPedido extends javax.swing.JFrame {

    
    
    
    DefaultTableModel modelTabelaPedido;
    boolean opcionais;
    ArrayList<Item> itens;
    Pedido pedido = new Pedido();
    float cbMassaIntegral, cbBordaChedar, cbBordaChoco, cbOutro, vlrTamanho, vlrPizza, vlrTotal;
    
    
    public telaPedido() {
        super("Peça sua Pizza");
        initComponents();
        itens = new ArrayList<>();
        modelTabelaPedido = (DefaultTableModel) tabelaPedido.getModel();        
    }
    
    public void calculaItem(){ 
       Item i = new Item();
       i.setSabor(buttonGroup1.getSelection().getActionCommand());
       i.setTamanho(buttonGroup2.getSelection().getActionCommand());
       i.setUnidade(Integer.parseInt(inputUnidade.getText()));
       if(checkMassaIntegral.isSelected()){
           opcionais = true;
       }else{
           opcionais = false;
       }
       if(checkBordaChedar.isSelected()){
           opcionais = true;
       }else{
           opcionais = false;
       }
       if(checkBordaChoco.isSelected()){
           opcionais = true;
       }else{
           opcionais = false;
       }
       if(checkMassaIntegral.isSelected()){
           opcionais = true;
       }else{
           opcionais = false;
       }
       if(checkOutro.isSelected()){
           opcionais = true;
       }else{
           opcionais = false;
       }
       itens.add(i);
       subTotal();
       lbSubTotal.setText(String.valueOf(vlrPizza));
        i.setValor(vlrPizza);
        totalPedido();
       
    }
    
   
    
    public void adicionarAoPedido(){
       modelTabelaPedido.getDataVector().clear();
       
       for(int i = 0; i < itens.size(); i++){
        Item  it = itens.get(i);
        modelTabelaPedido.addRow(new Object[]{(i+1), it.getSabor(), it.getTamanho(), it.getUnidade(), it.getValor()});
        }
    }
    
    public void subTotal(){
        vlrPizza = (vlrTamanho + cbMassaIntegral + cbBordaChedar + cbBordaChoco + cbOutro) * Integer.parseInt(inputUnidade.getText());
        
    }
    
    public void limpaCampos(){
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        checkMassaIntegral.setSelected(false);
        checkBordaChedar.setSelected(false);
        checkBordaChoco.setSelected(false);
        checkOutro.setSelected(false);
        inputUnidade.setText("");
        lbSubTotal.setText("");
    }
    
    public void limpaCamposCliente(){
        inputNomeCliente.setText("");
        inputFone.setText("");
        inputEndereco.setText("");
        jcCidade.setSelectedIndex(0);
    }
    
    public void excluiItem(){
        //Pega o sabor da pizza de uma linha da tabela
        String saborEliminado = String.valueOf(tabelaPedido.getModel().getValueAt(tabelaPedido.getSelectedRow(),1));
        
        //remove a linha selecionada da tabela
        modelTabelaPedido.removeRow(tabelaPedido.getSelectedRow());
        
        // Percorre o ArrayList e remove um elemento
        Item itEliminado = new Item();
        for (Item itemAtual : itens) {
            if(itemAtual.getSabor() == saborEliminado){
                itEliminado = itemAtual;
            }
        }
        itens.remove(itEliminado);
    }
  
    public void totalPedido(){
        vlrTotal = 0;
        for(Item itemAtual : itens){
            //System.out.println(vlrTotal);
           vlrTotal = vlrTotal + itemAtual.getValor();
           lbVlrTotal.setText(String.valueOf(vlrTotal));
          
        }
        
    }
    public void fecharPedido(){
        pedido.setCliente(inputNomeCliente.getText());
        pedido.setTelefone(inputFone.getText());
        pedido.setEndereco(inputEndereco.getText());
        pedido.setCidade(jcCidade.getSelectedItem().toString());
        String Menssagem = "Pedido realizado com sucesso! \n";
        
        try{
            FileWriter fw = new FileWriter("arq.txt");
            fw.write(Menssagem);
            fw.write("Nome: " + pedido. getCliente()+ "\n" + "Telefone: " + pedido.getTelefone()+ "\n" + "Endereço: "+ "\n" 
                    + pedido.getEndereco()+ "\n" + "Cidade: " + pedido.getCidade()+ "\n");
                
                for (Item i : itens){
            fw.write("Sabor da Pizza: " + i.getSabor() + "\n" + "Tamanho: " + i.getTamanho() + "\n"+ "Quantidade: " + i.getUnidade() + "\n\n");
            }
            fw.close();
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        JOptionPane.showMessageDialog(this, Menssagem, "Seu Pedido", JOptionPane.PLAIN_MESSAGE);
        
        pedido = new Pedido();
        itens = new ArrayList<>();
        limpaCamposCliente();
        modelTabelaPedido.getDataVector().clear();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jlNomePizzaria = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNomeCliente = new javax.swing.JLabel();
        inputNomeCliente = new javax.swing.JTextField();
        lbFone = new javax.swing.JLabel();
        inputFone = new javax.swing.JTextField();
        jlEndereco = new javax.swing.JLabel();
        inputEndereco = new javax.swing.JTextField();
        jlCidade = new javax.swing.JLabel();
        jcCidade = new javax.swing.JComboBox<>();
        lbCalabresa = new javax.swing.JLabel();
        radioCalabresa = new javax.swing.JRadioButton();
        lbMuzzarela = new javax.swing.JLabel();
        radioMuzzarela = new javax.swing.JRadioButton();
        lbPeperoni = new javax.swing.JLabel();
        radioPeperoni = new javax.swing.JRadioButton();
        lbPortuguesa = new javax.swing.JLabel();
        radioPortuguesa = new javax.swing.JRadioButton();
        lbManjericao = new javax.swing.JLabel();
        radioManjericao = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jlnidades = new javax.swing.JLabel();
        inputUnidade = new javax.swing.JTextField();
        btnCalculaItem = new javax.swing.JButton();
        btnAddPedido = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioPequena = new javax.swing.JRadioButton();
        radioMedia = new javax.swing.JRadioButton();
        radioGrande = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        checkMassaIntegral = new javax.swing.JCheckBox();
        checkBordaChedar = new javax.swing.JCheckBox();
        checkBordaChoco = new javax.swing.JCheckBox();
        checkOutro = new javax.swing.JCheckBox();
        jlTamanho = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbSubTotal = new javax.swing.JLabel();
        btnExcluirItem = new javax.swing.JButton();
        btnFecharPedido = new javax.swing.JButton();
        lbTotalPedido = new javax.swing.JLabel();
        lbVlrTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pizza images/DreamShaper_v7_marca_para_pizzaria_4.jpg"))); // NOI18N
        jLabel1.setText("jlLogoPizzaria");

        jlNomePizzaria.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jlNomePizzaria.setText("Pizzaria Cannes");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("- Pedido - ");

        lbNomeCliente.setText("Nome do Cliente");

        lbFone.setText("Telefone");

        jlEndereco.setText("Endereço");

        inputEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEnderecoActionPerformed(evt);
            }
        });

        jlCidade.setText("Cidade");

        jcCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porto Alegre", "Canoas", "IEsteio", "Cachoeirinha", "Alvorada", "Gravataí" }));

        lbCalabresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pizza images/calabresa.png"))); // NOI18N

        buttonGroup1.add(radioCalabresa);
        radioCalabresa.setText("Calabresa");
        radioCalabresa.setActionCommand("Calabresa");
        radioCalabresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCalabresaActionPerformed(evt);
            }
        });

        lbMuzzarela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pizza images/muzzarela.png"))); // NOI18N

        buttonGroup1.add(radioMuzzarela);
        radioMuzzarela.setText("Muzzarela");
        radioMuzzarela.setActionCommand("Muzzarela");
        radioMuzzarela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMuzzarelaActionPerformed(evt);
            }
        });

        lbPeperoni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pizza images/pizza1.png"))); // NOI18N

        buttonGroup1.add(radioPeperoni);
        radioPeperoni.setText("Peperoni");
        radioPeperoni.setActionCommand("Peperoni");
        radioPeperoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPeperoniActionPerformed(evt);
            }
        });

        lbPortuguesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pizza images/pizza2.png"))); // NOI18N

        buttonGroup1.add(radioPortuguesa);
        radioPortuguesa.setText("Portuguesa");
        radioPortuguesa.setActionCommand("Portuguesa");
        radioPortuguesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPortuguesaActionPerformed(evt);
            }
        });

        lbManjericao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pizza images/portuguesa.png"))); // NOI18N

        buttonGroup1.add(radioManjericao);
        radioManjericao.setText("Manjericão");
        radioManjericao.setActionCommand("Manjericão");
        radioManjericao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioManjericaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Opcionais");

        jlnidades.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlnidades.setText("Unidades");

        btnCalculaItem.setText("Calcula Item");
        btnCalculaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculaItemActionPerformed(evt);
            }
        });

        btnAddPedido.setText("Adicionar ao Pedido");
        btnAddPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPedidoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        buttonGroup2.add(radioPequena);
        radioPequena.setText("Pequena");
        radioPequena.setActionCommand("Pequena");
        radioPequena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPequenaActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioMedia);
        radioMedia.setText("Media");
        radioMedia.setActionCommand("Média");
        radioMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMediaActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioGrande);
        radioGrande.setText("Grande");
        radioGrande.setActionCommand("Grande");
        radioGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGrandeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioPequena)
                .addGap(65, 65, 65)
                .addComponent(radioMedia)
                .addGap(71, 71, 71)
                .addComponent(radioGrande)
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPequena)
                    .addComponent(radioMedia)
                    .addComponent(radioGrande))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        checkMassaIntegral.setText("Massa Integral");
        checkMassaIntegral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMassaIntegralActionPerformed(evt);
            }
        });

        checkBordaChedar.setText("Borda Chedar");
        checkBordaChedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBordaChedarActionPerformed(evt);
            }
        });

        checkBordaChoco.setText("Borda Chocolate");
        checkBordaChoco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBordaChocoActionPerformed(evt);
            }
        });

        checkOutro.setText("Outro");
        checkOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(checkMassaIntegral)
                .addGap(32, 32, 32)
                .addComponent(checkBordaChedar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkBordaChoco)
                .addGap(40, 40, 40)
                .addComponent(checkOutro)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMassaIntegral)
                    .addComponent(checkBordaChedar)
                    .addComponent(checkBordaChoco)
                    .addComponent(checkOutro))
                .addContainerGap())
        );

        jlTamanho.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlTamanho.setText("Tamanho");

        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num do Pedido", "Pizza", "Tamanho", "Unidade", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tabelaPedido);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("SubTotal  R$");

        lbSubTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnExcluirItem.setText("Excluir item");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        btnFecharPedido.setText("Fechar Pedido");
        btnFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharPedidoActionPerformed(evt);
            }
        });

        lbTotalPedido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbTotalPedido.setText("Total Pedido:  R$");

        lbVlrTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbCalabresa)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioCalabresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMuzzarela, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioMuzzarela))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPeperoni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioPeperoni))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPortuguesa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioPortuguesa))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbManjericao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioManjericao))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel2)
                                .addGap(102, 102, 102))
                            .addComponent(jlNomePizzaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTamanho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnExcluirItem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnFecharPedido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbTotalPedido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbVlrTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jlnidades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalculaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lbSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jlEndereco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputEndereco))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbNomeCliente)
                                        .addGap(4, 4, 4)
                                        .addComponent(inputNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlCidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lbFone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputFone, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlNomePizzaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeCliente)
                    .addComponent(inputNomeCliente)
                    .addComponent(lbFone)
                    .addComponent(inputFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEndereco)
                    .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCidade)
                    .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPortuguesa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCalabresa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMuzzarela, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPeperoni, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbManjericao, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioMuzzarela)
                    .addComponent(radioPortuguesa)
                    .addComponent(radioPeperoni)
                    .addComponent(radioManjericao)
                    .addComponent(radioCalabresa))
                .addGap(18, 18, 18)
                .addComponent(jlTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalculaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlnidades))
                    .addComponent(btnAddPedido))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirItem)
                    .addComponent(btnFecharPedido)
                    .addComponent(lbTotalPedido)
                    .addComponent(lbVlrTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEnderecoActionPerformed

    private void radioMuzzarelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMuzzarelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMuzzarelaActionPerformed

    private void radioPeperoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPeperoniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPeperoniActionPerformed

    private void radioPortuguesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPortuguesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPortuguesaActionPerformed

    private void radioManjericaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioManjericaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioManjericaoActionPerformed

    private void radioPequenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPequenaActionPerformed
            vlrTamanho = 60.0f;
    }//GEN-LAST:event_radioPequenaActionPerformed

    private void checkBordaChedarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBordaChedarActionPerformed
        cbBordaChedar = 7.50f;
    }//GEN-LAST:event_checkBordaChedarActionPerformed

    private void radioCalabresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCalabresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCalabresaActionPerformed

    private void btnAddPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPedidoActionPerformed
       adicionarAoPedido();
       limpaCampos();
    }//GEN-LAST:event_btnAddPedidoActionPerformed

    private void btnCalculaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculaItemActionPerformed
        calculaItem();
    }//GEN-LAST:event_btnCalculaItemActionPerformed

    private void checkMassaIntegralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMassaIntegralActionPerformed
        cbMassaIntegral = 6.50f;
    }//GEN-LAST:event_checkMassaIntegralActionPerformed

    private void checkBordaChocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBordaChocoActionPerformed
        cbBordaChoco = 10.50f;
    }//GEN-LAST:event_checkBordaChocoActionPerformed

    private void checkOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutroActionPerformed
        cbOutro = 4.50f;
    }//GEN-LAST:event_checkOutroActionPerformed

    private void radioMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMediaActionPerformed
        vlrTamanho = 75.0f;
    }//GEN-LAST:event_radioMediaActionPerformed

    private void radioGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGrandeActionPerformed
        vlrTamanho = 85.0f;
    }//GEN-LAST:event_radioGrandeActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        excluiItem();
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPedidoActionPerformed
        fecharPedido();
    }//GEN-LAST:event_btnFecharPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPedido;
    private javax.swing.JButton btnCalculaItem;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFecharPedido;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox checkBordaChedar;
    private javax.swing.JCheckBox checkBordaChoco;
    private javax.swing.JCheckBox checkMassaIntegral;
    private javax.swing.JCheckBox checkOutro;
    private javax.swing.JTextField inputEndereco;
    private javax.swing.JTextField inputFone;
    private javax.swing.JTextField inputNomeCliente;
    private javax.swing.JTextField inputUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCidade;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlNomePizzaria;
    private javax.swing.JLabel jlTamanho;
    private javax.swing.JLabel jlnidades;
    private javax.swing.JLabel lbCalabresa;
    private javax.swing.JLabel lbFone;
    private javax.swing.JLabel lbManjericao;
    private javax.swing.JLabel lbMuzzarela;
    private javax.swing.JLabel lbNomeCliente;
    private javax.swing.JLabel lbPeperoni;
    private javax.swing.JLabel lbPortuguesa;
    private javax.swing.JLabel lbSubTotal;
    private javax.swing.JLabel lbTotalPedido;
    private javax.swing.JLabel lbVlrTotal;
    private javax.swing.JRadioButton radioCalabresa;
    private javax.swing.JRadioButton radioGrande;
    private javax.swing.JRadioButton radioManjericao;
    private javax.swing.JRadioButton radioMedia;
    private javax.swing.JRadioButton radioMuzzarela;
    private javax.swing.JRadioButton radioPeperoni;
    private javax.swing.JRadioButton radioPequena;
    private javax.swing.JRadioButton radioPortuguesa;
    private javax.swing.JTable tabelaPedido;
    // End of variables declaration//GEN-END:variables
}
