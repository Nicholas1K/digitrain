import React from "react";
import {
  Box,
  Grid,
  Typography,
  List,
  ListItem,
  Button,
  Paper,
  FormControl,
  Select,
  MenuItem,
  InputLabel,
} from "@mui/material";
import { isEmpty } from "lodash";

export default function ListaTreni({
  viaggi,
  onSelectTrain,
  onSelectTypeOfTrip,
}) {
  const [typeOfTrip, setTypeOfTrip] = React.useState("");

  const handleSelectTrain = (viaggio) => {
    onSelectTrain(viaggio);
  };

  const handleSelectTypeOfTrip = (e) => {
    onSelectTypeOfTrip(e.target.value);
    setTypeOfTrip(e.target.value);
  };

  if (isEmpty(viaggi)) {
    return null;
  } else {
    return (
      <Box>
        <Paper>
          <List>
            {viaggi.map((viaggio) => {
              return (
                <ListItem key={viaggio.id}>
                  <Grid
                    container
                    direction="row"
                    justifyContent="space-around"
                    alignItems="center"
                    spacing={2}
                  >
                    <Grid item xs={3}>
                      <Typography variant="overline">
                        {viaggio.departureTime.split("T").join(" ")}
                      </Typography>
                      <Typography variant="h6">
                        {viaggio.departureCity}
                      </Typography>
                    </Grid>

                    <Grid item xs={3}>
                      <Typography variant="overline">
                        {viaggio.arrivalTime.split("T").join(" ")}
                      </Typography>
                      <Typography variant="h6">
                        {viaggio.arrivalCity}
                      </Typography>
                    </Grid>

                    <Grid item xs={3}>
                      <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">
                          Seleziona servizio e offerta
                        </InputLabel>
                        <Select
                          labelId="demo-simple-select-label"
                          id="demo-simple-select"
                          value={typeOfTrip}
                          label="Seleziona servizio e offerta"
                          onChange={handleSelectTypeOfTrip}
                        >
                          <MenuItem value="Economy">Economy</MenuItem>
                          <MenuItem value="Business">Business</MenuItem>
                          <MenuItem value="Premium">Premium</MenuItem>
                        </Select>
                      </FormControl>
                    </Grid>

                    <Grid item xs={2}>
                      <Button
                        fullWidth
                        onClick={() => handleSelectTrain(viaggio)}
                      >
                        Seleziona
                      </Button>
                    </Grid>
                  </Grid>
                </ListItem>
              );
            })}
          </List>
        </Paper>
      </Box>
    );
  }
}
