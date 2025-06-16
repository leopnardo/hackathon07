import express, { Request, Response } from 'express';
import cors from 'cors';
import db from './db';
import bodyParser from 'body-parser';
const app = express();
const port = 3000;

app.use(cors());
app.use(bodyParser.json());

interface Event {
  id: number;
  title: string;
  start: string;
  end: string | null;
  speaker: string;
  curriculum: string;
  theme: string;
  photo: string | null
}

//puxa dados do evento do banco pra mostrar no div da pagina
app.get('/api/events', async (req: Request, res: Response) => {
  try {
    const [rows] = await db.query('SELECT id, title, start, end, speaker, curriculum, theme, photo FROM eventos');

    const formatted: Event[] = (rows as Event[]).map((event: Event) => ({
      id: event.id,
      title: event.title,
      start: event.start,
      end: event.end,
      speaker: event.speaker,
      curriculum: event.curriculum,
      theme: event.theme,
      photo: event.photo
    }));

    res.json(formatted);
  } catch (err) {
    console.error('Erro ao buscar eventos:', err);
    res.status(500).json({ error: 'Erro ao buscar eventos' });
  }
});

app.listen(port, () => {
  console.log(`Servidor iniciou na PORTA: ${port}`);
});

interface Aluno {
  id: number;
  ra: number;
  name: string;
  cpf: number;
  evento_id: number
}

//manda os dados da inscricao do aluno pro banco, isso o php q mandou
app.post('/api/register', async (req: Request, res: Response) => {
  const { ra, cpf, name, evento_id } = req.body as Aluno;
  try {
    await db.query(
      'INSERT INTO aluno (ra, cpf, name, evento_id) VALUES (?, ?, ?, ?)',
      [ra, cpf, name, evento_id]
    );
    res.status(201).json({ message: 'Inscrição realizada com sucesso!' });
  } catch (err) {
    console.error('Erro ao inserir inscrição:', err);
    res.status(500).json({ error: 'Erro ao realizar inscrição.' });
  }
});