public class TrocoMoeda {
        private double moeda;
        private int quantidade;
    
        public TrocoMoeda(double moedas, int quantidade) {
            this.moeda = moedas;
            this.quantidade = quantidade;
        }
    
        public double getMoeda() {
            return moeda;
        }
    
        public void setMoeda(int moeda) {
            this.moeda = moeda;
        }
    
        public int getQuantidade() {
            return quantidade;
        }
    
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }

