import Layout from "../components/Layout";
import { Typography, Box } from "@mui/material";

const Conditions = () => {
  return (
    <Layout>
      <Box mb={3}>
        <Typography variant="h3" component="h4">
          Condizioni d'utilizzo
        </Typography>
      </Box>
      <Typography>
        Digitatrain è la compagnia ferroviaria nazionale che offre diverse
        tipologie di biglietti (Economy, Business, Premium) per viaggiare nella
        classe che preferisci e con tutti i comfort di cui hai bisogno! Potrai
        inoltre scegliere la modalità di pagamento (Paypal, Carta di credito,
        Contanti) e scoprire il saldo della tua cartaFreccia. Sei pronto a
        partire? Inserisci la stazione di partenza, di arrivo e la data nel
        pianificatore di viaggio ad inizio pagina e cerca subito la soluzione di
        viaggio che fa per te: Digitatrain ti porta verso i tuoi sogni!
      </Typography>
    </Layout>
  );
};
export default Conditions;
