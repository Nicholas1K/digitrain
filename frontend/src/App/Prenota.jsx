import React from "react";
import {
  Box,
  Typography,
  Alert,
  TextField,
  Paper,
  Button,
} from "@mui/material";
import Layout from "../components/Layout";
import CercaTreno from "../components/CercaTreno";
import api from "../api";
import ListaTreni from "../components/ListaTreni";
import { isEmpty } from "lodash";
import Train from "../components/Train";
import { useNavigate } from "react-router-dom";

const Prenota = () => {
  const navigate = useNavigate();
  const [name, setName] = React.useState("");
  const [codeCartaFreccia, setCodeCartaFreccia] = React.useState("");
  const [viaggi, setViaggi] = React.useState([]);
  const [viaggiError, setViaggiError] = React.useState(false);
  const [train, setTrain] = React.useState();
  const [trip, setTypeOfTrip] = React.useState();

  const handlePrenota = () => {
    const reservation = {
      carriageNumber: Math.floor(Math.random() * 10),
      locationCode: Math.floor(Math.random() * 100),
      typeOfTrip: trip,
      totalAmount: Math.floor(Math.random() * 100),
      passenger: {
        name: name,
        codeCartaFreccia: codeCartaFreccia,
      },
      travel: train,
    };

    api
      .post("/reservation/create", reservation)
      .then((response) => navigate("/prenotazione/" + response.data.id))
      .catch((error) => console.log(error));
  };

  const handleSubmit = (travelQuery) => {
    api
      .get(
        `/travels/bothcitiesandtime?departure=${travelQuery.departureCity}&arrival=${travelQuery.arrivalCity}&time=${travelQuery.departureTime}`
      )
      .then((response) => {
        setViaggi(response.data);
        setViaggiError(false);
      })
      .catch((error) => {
        console.log(error);
        setViaggi([]);
        setViaggiError(true);
      });
  };

  return (
    <Layout>
      <Box mb={3}>
        <Typography variant="h3" component="h4">
          Prenota ora il tuo treno!
        </Typography>
      </Box>

      <Box mb={3}>
        <Paper>
          <Box p={2}>
            <TextField
              fullWidth
              label="nome e cognome"
              value={name}
              error={name.length < 1}
              onChange={(e) => setName(e.target.value)}
              margin="normal"
            />
            <TextField
              fullWidth
              label="Codice Carta Freccia"
              value={codeCartaFreccia}
              error={codeCartaFreccia.length < 1}
              onChange={(e) => setCodeCartaFreccia(e.target.value)}
            />
          </Box>
        </Paper>
      </Box>

      <CercaTreno onSubmit={handleSubmit} />

      {viaggiError && <Alert severity="error">C'è stato un problema!</Alert>}

      {isEmpty(train) && !viaggiError && (
        <ListaTreni
          viaggi={viaggi}
          onSelectTrain={setTrain}
          onSelectTypeOfTrip={setTypeOfTrip}
        />
      )}

      {!isEmpty(train) && <Train viaggio={train} typeOfTrip={trip} />}

      <Box>
        <Button onClick={handlePrenota}>Prenota</Button>
      </Box>
    </Layout>
  );
};

export default Prenota;
